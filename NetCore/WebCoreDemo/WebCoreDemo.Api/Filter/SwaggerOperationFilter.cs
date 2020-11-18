using Swashbuckle.AspNetCore.Swagger;
using Swashbuckle.AspNetCore.SwaggerGen;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace WebCoreDemo.Api.Filter
{
    public class SwaggerOperationFilter : IOperationFilter
    {
        /// <summary>
        /// 应用过滤器
        /// </summary>
        /// <param name="operation"></param>
        /// <param name="context"></param>
        public void Apply(Operation operation, OperationFilterContext context)
        {
            #region Swagger版本描述处理
            foreach (var parameter in operation.Parameters.OfType<NonBodyParameter>())
            {
                var description = context.ApiDescription.ParameterDescriptions.First(p => p.Name == parameter.Name);
                if (parameter.Description == null)
                {
                    //parameter.Description = "填写版本号如:1.0";
                    parameter.Default = context.ApiDescription.GroupName.Replace("v", "");
                }
            }
            #endregion
        }
    }
}
