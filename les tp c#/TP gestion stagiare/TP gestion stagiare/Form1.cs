using System.Data;
using MySql.Data.MySqlClient;

namespace TP_gestion_stagiare
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void button4_Click(object sender, EventArgs e)
        {
            using MySqlConnection cnx = Databasecnx.Get();
            using MySqlCommand cmd = new MySqlCommand("SELECT * FROM stagiaire", cnx);
            cnx.Open();
            using MySqlDataReader dr = cmd.ExecuteReader();
            DataTable stagiaire = new DataTable();
            stagiaire.Load(dr);
            dataGridView1.DataSource = stagiaire;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            using MySqlConnection cnx = Databasecnx.Get();
            MySqlCommand cmd = new MySqlCommand("INSERT INTO stagiaire (id_stg, nom_complet, adress, telephone) VALUES ('"
                + textBox1.Text + "','" + textBox2.Text + "','" + textBox3.Text + "','" + int.Parse(textBox4.Text) + "')", cnx);
            cnx.Open();
            cmd.ExecuteNonQuery();
            cnx.Close();

            MessageBox.Show("Client ajouter  avec succes !");
            textBox1.Clear();
            textBox2.Clear();
            textBox3.Clear();
            textBox4.Clear();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            using MySqlConnection cnx = Databasecnx.Get();
            if (string.IsNullOrEmpty(textBox5.Text))
            {
                MySqlCommand cmd = new MySqlCommand("DELETE FROM stagiaire WHERE id_stg = '" + textBox5.Text + "'", cnx);
                cnx.Open();
                cmd.ExecuteNonQuery();
                cnx.Close();
                MessageBox.Show("supprimer avec succes");
                textBox5.Clear();
            }
            else
            {
                MessageBox.Show("remplirer le bar de recherch");
            }

        }

        private void button3_Click(object sender, EventArgs e)
        {
            using MySqlConnection cnx = Databasecnx.Get();
            using MySqlCommand cmd = new MySqlCommand("SELECT * FROM stagiaire WHERE id_stg = '" + textBox5.Text + "'", cnx); ;
            cnx.Open();
            using MySqlDataReader dr = cmd.ExecuteReader();
            DataTable stagiaire = new DataTable();
            stagiaire.Load(dr);
            dataGridView1.DataSource = stagiaire;
            textBox5.Clear();
        }

        private void button5_Click(object sender, EventArgs e)
        {
            textBox1.Clear();
            textBox2.Clear();
            textBox3.Clear();
            textBox4.Clear();
            textBox5.Clear();
        }
    }
}


public static class Databasecnx
{
    private static string Strcnx = "Server=localhost;Port=3308;Database=gestion stagiaire;Uid=root;Pwd=;";

    public static MySqlConnection Get()
    {
        return new MySqlConnection(Strcnx);
    }

}

