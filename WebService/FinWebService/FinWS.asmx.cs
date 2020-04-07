using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace FinWebServiceApp
{
    /// <summary>
    /// Summary description for FinWS
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class FinWS : System.Web.Services.WebService
    {

        [WebMethod]
        public ResultVMs Login(string loginName, string password)
        {
          
            ResultVMs result = new ResultVMs();
            DataClassesDataContext db = new DataClassesDataContext();
            try
            {
               
                if (db.GeneralUsers.Any(c => c.UserName == loginName))
                {
                    result.ValidEmployee = true;
                    return result;

                }
                else
                {
                    result.ValidEmployee = false;
                }

            }
            catch (Exception ex)
            {
                result.ErrorMsg = ex.Message;
            }

            return result;

        }

    }
}
