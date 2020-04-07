using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LibyanGovGuideWSApp
{
   

    public class ProcedureVM
    {
    
        public short ProcedureID { get; set; }
    
        public string ProcedureName { get; set; }

        public string LastUpdate { get; set; }

        public string Note { get; set; }
     
    }
    public class ProcedureDetailVM
    {

        //public short ProcedureID { get; set; }

        //public short ProcedureDetailID { get; set; }

        public string Title { get; set; }

    }
}