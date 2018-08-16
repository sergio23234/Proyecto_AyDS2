using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;

namespace App_Adminsitrador.MySQL
{
    class conexion
    {
        public static MySqlConnection obtenerConexion()
        {
            MySqlConnection conexion = new MySqlConnection("server=35.202.163.254;database=pensum;Uid=admin;pwd=1234");
            conexion.Open();
            return conexion;
        }
    }
}
