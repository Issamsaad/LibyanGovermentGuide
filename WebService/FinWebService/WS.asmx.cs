using System;
using System.Collections.Generic;
using System.Linq;




using System.Web.Services;
using System.Web.Script.Serialization;
namespace LibyanGovGuideWSApp
{
    /// <summary>
    /// Summary description for WS
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class WS : System.Web.Services.WebService
    {

        List<ProcedureVM> result = new List<ProcedureVM>();

        [WebMethod]
        public void GetProcedure(short procedureID)
        {
            DataClassesDataContext db = new DataClassesDataContext();
         
            T_Procedure t = db.T_Procedures.Single(c => c.ProcedureID == procedureID);

            result.Add(new ProcedureVM()
            {
                    ProcedureID=t.ProcedureID,
                    ProcedureName=t.ProcedureName,
                    LastUpdate=t.LastUpdate.ToShortDateString(),
                    Note=t.Note
                });
                 

            this.Context.Response.ContentType = "application/json; charset=utf-8";
            this.Context.Response.Write(new JavaScriptSerializer().Serialize(result));


        }
        [WebMethod]
        public void GetActiveProcedure(short classification)
        {
            DataClassesDataContext db = new DataClassesDataContext();
          
            ProcedureVM item;
            List<T_Procedure> dataList = db.T_Procedures.Where(c => c.Classification == classification).ToList();
            foreach (T_Procedure t in dataList)
            {
                item = new ProcedureVM();
                item.ProcedureID = t.ProcedureID;
                item.ProcedureName = t.ProcedureName;
                item.LastUpdate = t.LastUpdate.ToShortDateString();
                result.Add(item);
            }
          


            this.Context.Response.ContentType = "application/json; charset=utf-8";
            this.Context.Response.Write(new JavaScriptSerializer().Serialize(result));


        }
        [WebMethod]
        public void GetActiveClassifcations()
        {
            DataClassesDataContext db = new DataClassesDataContext();

            ProcedureVM item;
            List<T_Classifcation> dataList = db.T_Classifcations.Where(f=>f.ActivityStatus)
                .ToList();
          

            this.Context.Response.ContentType = "application/json; charset=utf-8";
            this.Context.Response.Write(new JavaScriptSerializer().Serialize(dataList));


        }
        [WebMethod]
        public void GetProcedureDetails(int procedureID = 1)
        {
            DataClassesDataContext db = new DataClassesDataContext();
            List<T_ProcedureDetail> detailsList = db.T_ProcedureDetails.Where(c => c.ProcedureID == procedureID).ToList();
            List<ProcedureDetailVM> currentList = new List<ProcedureDetailVM>();
            ProcedureDetailVM current = new ProcedureDetailVM();
            foreach (T_ProcedureDetail t in detailsList)
            {
                current = new ProcedureDetailVM();
                current.Title = t.Title;
                currentList.Add(current);
            }

            this.Context.Response.ContentType = "application/json; charset=utf-8";
            this.Context.Response.Write(new JavaScriptSerializer().Serialize(currentList));

        }
    }
}
