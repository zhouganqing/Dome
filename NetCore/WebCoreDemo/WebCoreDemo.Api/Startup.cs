using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.ApiExplorer;
using Microsoft.AspNetCore.Mvc.Versioning;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Logging;
using Microsoft.Extensions.Options;
using Microsoft.Extensions.PlatformAbstractions;
using Swashbuckle.AspNetCore.Swagger;
using WebCoreDemo.Api.Filter;

namespace WebCoreDemo.Api
{
    public class Startup
    {
        /// <summary>
        /// Api版本提者信息
        /// </summary>
        private IApiVersionDescriptionProvider provider;

        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        public IConfiguration Configuration { get; }

        // This method gets called by the runtime. Use this method to add services to the container.
        public void ConfigureServices(IServiceCollection services)
        {
            #region 不用版本控制器
            //services.AddMvc();
            /*services.AddSwaggerGen(c =>
            {
                c.SwaggerDoc("v1", new Info
                {
                    Version = "v1.0",
                    Title = "Demo微服务接口",
                    Contact = new Contact() { Name = "周干清", Email = "zhouganiqng@126.com" }
                });

                //XML注释解析
                c.IncludeXmlComments(GetXmlPath("Api"));
                c.IncludeXmlComments(GetXmlPath("Model"));
            });*/

            #endregion

            #region 使用版本控制
            services.AddApiVersioning(
                option =>
                {
                    // 可选，为true时API返回支持的版本信息
                    option.ReportApiVersions = false;
                    //header控制版本
                    option.ApiVersionReader = new HeaderApiVersionReader("api-version");
                    //参数和路径提供版本控制
                    //option.ApiVersionReader = new QueryStringApiVersionReader("version");

                    //option.ApiVersionReader = new MediaTypeApiVersionReader();
                    //option.ApiVersionSelector = new CurrentImplementationApiVersionSelector(option);

                    // 现有项目下加该参数，新项目不需要。不提供版本时，默认为1.0
                    option.AssumeDefaultVersionWhenUnspecified = true;
                    // 请求中未指定版本时默认为1.0
                    option.DefaultApiVersion = new ApiVersion(1, 0);
                }).AddVersionedApiExplorer(option =>
                {
                    option.GroupNameFormat = "'v'V";//"'v'VVV";
                    option.AssumeDefaultVersionWhenUnspecified = true;
                });

            this.provider = services.BuildServiceProvider().GetRequiredService<IApiVersionDescriptionProvider>();

            services.AddSwaggerGen(
                options =>
                {
                    foreach (var description in provider.ApiVersionDescriptions)
                    {
                        options.SwaggerDoc(description.GroupName, CreateInfoForApiVersion(description));
                    }
                    //设置默认版本
                    options.OperationFilter<SwaggerOperationFilter>();
                    //XML注释解析
                    options.IncludeXmlComments(GetXmlPath("Api"));
                    options.IncludeXmlComments(GetXmlPath("Model"));
                });

            services.AddMvc().SetCompatibilityVersion(CompatibilityVersion.Version_2_1);
            services.AddMvc().SetCompatibilityVersion(CompatibilityVersion.Version_2_2);
            #endregion
        }


        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, IHostingEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }

            #region Swagger版本控制
            //注册swagger
            app.UseSwagger();

            //不使用版本控制
            /*app.UseSwaggerUI(c =>
            {
                c.SwaggerEndpoint("/swagger/v1/swagger.json", "Demo API V1");
            });*/

            //版本控制
            app.UseSwaggerUI(
                options =>
                {
                    foreach (var description in provider.ApiVersionDescriptions)
                    {
                        options.SwaggerEndpoint($"/swagger/{description.GroupName}/swagger.json", description.GroupName.ToUpperInvariant()); //description.ApiVersion
                    }
                });
            #endregion

            app.UseMvc();
        }

        private string GetXmlPath(string name)
        {
            var basePath = PlatformServices.Default.Application.ApplicationBasePath;
            var xmlPath = Path.Combine(basePath, $"WebCoreDemo.{name}.xml");
            return xmlPath;
        }

        private Info CreateInfoForApiVersion(ApiVersionDescription description)
        {
            return new Info()
            {
                Title = $"Demo接口 v{description.ApiVersion}",    //标题
                Version = description.ApiVersion.ToString(),//版本号
                Description = "切换版本请点右上角版本切换",//注释，备注
                Contact = new Contact() { Name = "周干清", Email = "zhouganiqng@126.com" }
            };
        }
    }
}
