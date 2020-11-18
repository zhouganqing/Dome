package cn.zhougq.controller;

import cn.zhougq.entytis.NewsMod;
import cn.zhougq.service.INewsService;
import cn.zhougq.util.Constants;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouganqing
 * @create 2020- 07- 25- 15:43
 */

@Controller
@RequestMapping("news")
public class NewsController {

    Logger log =  LoggerFactory.getLogger(NewsController.class);
    @Autowired
    INewsService newsService;

    @RequestMapping(value ="/getList")
    public String getList(Model mod, HttpSession session) {
        if (session.getAttribute(Constants.USER_SESSION)==null)
        {
            return  "redirect:/user/login";
        }
        mod.addAttribute("list",newsService.getList());
        return "news";
    }

    @RequestMapping(value = "addNews",method = RequestMethod.GET)
    public String addNews(@ModelAttribute("news")NewsMod mod)
    {
        return "addNews";
    }

    @RequestMapping(value = "addNews",method = RequestMethod.POST)
    public String addNews(NewsMod news,HttpSession session,HttpServletRequest request,
                          @RequestParam(value = "imgPath",required = false)MultipartFile artfile)
    {
        log.info(news.toString());

        String imgPath=null;
        if (artfile!=null)
        {
            String path = request.getSession().getServletContext().getRealPath("statics"+ File.separator+"uploadfiles");
            log.info("upload filepath:"+path);
            //原文件名
            String oldFileName = artfile.getOriginalFilename();
            log.info("原文件名："+oldFileName);
            //原文件后缀
            String prefix = FilenameUtils.getExtension(oldFileName);
            log.info("原文件后缀："+prefix);
            //文件大小
            long size=artfile.getSize();
            log.info("原文件大小："+size);
            if (size>5000000)//文件大小不能超过500KB
            {
                request.setAttribute("error","文件大小不能超过500KB");
                return "addNews";
            }
            //图片格式;prefix.equalsIgnoreCase 比较对象是否相等并忽略大小写
            String imgStr="jpg,png,jpeg,pneg";
            //判断格式是否存在
            if (!imgStr.contains(prefix.toLowerCase()))
            {
                request.setAttribute("error","文件格式不正确");
                return "addNews";
            }
            //重命名
            String fileName = System.currentTimeMillis()+"_img."+prefix;
            log.info("新文件名："+fileName);

            File tFile = new File(path,fileName);
            if (!tFile.exists())
            {
                tFile.mkdirs();
            }

            try {
                artfile.transferTo(tFile);
            } catch (IOException e) {
                e.printStackTrace();
                request.setAttribute("error","上传失败！");
                return "addNews";
            }
        }

        newsService.addNews(news);
        return "redirect:getList";
    }



    @RequestMapping(value = "addNewsFm",method = RequestMethod.GET)
    public String addNewsFm(@ModelAttribute("news")NewsMod mod)
    {
        return "addNewsFm";
    }

    /*spring标签+文件上传+前端错误提示*/
    @RequestMapping(value = "addNewsFm",method = RequestMethod.POST)
    public String addNewsFm(NewsMod news,HttpSession session
    ,HttpServletRequest request,@RequestParam(value = "imgPath",required = false)MultipartFile[] artfiles)
    {
        String path = request.getSession().getServletContext().getRealPath("statics"+ File.separator+"uploadfiles");
        for (MultipartFile file: artfiles) {
            String oldFileName = file.getOriginalFilename();
            String prefix = FilenameUtils.getExtension(oldFileName);
            String fileName = System.currentTimeMillis()+"_img."+prefix;

            File tFile = new File(path,fileName);
            if (!tFile.exists())
            {
                tFile.mkdirs();
            }

            try {
                file.transferTo(tFile);
            } catch (IOException e) {
                e.printStackTrace();
                request.setAttribute("error","上传失败！");
                return "addNewsFM";
            }
        }


        log.info(news.toString());
        newsService.addNews(news);
        return "redirect:getList";
    }

    @RequestMapping(value = "view/{id}",method = RequestMethod.GET)
    public String view(@PathVariable Integer id,Model mod)
    {
        log.info(id.toString());
        mod.addAttribute("news",newsService.getNewMod(id));
        return "viewNews";
    }

}
