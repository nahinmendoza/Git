package ProyF;
import javax.swing.*;
import java.awt.event.*;



public class Mendoza950ProyFinal implements ActionListener{ 

    JFrame ventana;
    JMenuBar menuBar;
    JMenu mInicio, mMantenimiento;
    JMenuItem miPresentacion, miSalir, mmPaciente, mmMedico;
    JLabel lbl_presentacion1, lbl_presentacion2, lbl_presentacion3, lbl_presentacion4, lbl_presentacion5,
            lbl_presentacion6, lbl_presentacion7, lbl_presentacion8, lbl_presentacion9;
    JButton   btn_limpiar,btn_buscar,btn_adicionar,btn_modificar,btn_eliminar,btn_listar;
    
    public static void main(String[] args)
    {
        new Mendoza950ProyFinal();
        new PBD();
    }

    Mendoza950ProyFinal()
    {
        ventana = new JFrame("Menu");
        ventana.setBounds(50,50,800,800);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);

        menuBar = new JMenuBar();

        mInicio = new JMenu("Inicio");
        mMantenimiento = new JMenu("Mantenimiento");

        miPresentacion = new JMenuItem("Presentacion");
        miPresentacion.addActionListener(this);
        miSalir = new JMenuItem("Salir");
        miSalir.addActionListener(this);
        
        mmPaciente = new JMenuItem("Paciente");
        mmPaciente.addActionListener(this);
        mmMedico = new JMenuItem("Medico");
        mmMedico.addActionListener(this);


    

        mMantenimiento.add(mmPaciente);
        mMantenimiento.add(mmMedico);
        mInicio.add(miPresentacion);
        mInicio.add(miSalir);
        menuBar.add(mInicio);
        menuBar.add(mMantenimiento);
        ventana.setJMenuBar(menuBar);

        
        
        lbl_presentacion1 = new JLabel("UNIVERSIDAD TECNOLOGICA DE PANAMA\n");
        lbl_presentacion1.setBounds(160, 150, 450, 200);
        lbl_presentacion1.setVisible(false);
        ventana.add(lbl_presentacion1);

        lbl_presentacion2 = new JLabel("FACULTAD DE INGENIERIA DE SISTEMAS COMPUTACIONALES\n");
        lbl_presentacion2.setBounds(100, 170, 450, 200);
        lbl_presentacion2.setVisible(false);
        ventana.add(lbl_presentacion2);

        lbl_presentacion3 = new JLabel("LIC. EN DESARROLLO DE SOFTWARE\n");
        lbl_presentacion3.setBounds(180, 190, 450, 200);
        lbl_presentacion3.setVisible(false);
        ventana.add(lbl_presentacion3);

        lbl_presentacion4 = new JLabel("DESARROLLO DE SOFTWARE 3\n");
        lbl_presentacion4.setBounds(195, 210, 450, 200);
        lbl_presentacion4.setVisible(false);
        ventana.add(lbl_presentacion4);

        lbl_presentacion5 = new JLabel("RICARDO CHAN\n");
        lbl_presentacion5.setBounds(240, 230, 450, 200);
        lbl_presentacion5.setVisible(false);
        ventana.add(lbl_presentacion5);

        lbl_presentacion6 = new JLabel("NAHIN MENDOZA\n");
        lbl_presentacion6.setBounds(235, 250, 450, 200);
        lbl_presentacion6.setVisible(false);
        ventana.add(lbl_presentacion6);

        lbl_presentacion7 = new JLabel("8-989-50\n");
        lbl_presentacion7.setBounds(255, 270, 450, 200);
        lbl_presentacion7.setVisible(false);
        ventana.add(lbl_presentacion7);

        lbl_presentacion8 = new JLabel("1LS221\n");
        lbl_presentacion8.setBounds(260, 290, 450, 200);
        lbl_presentacion8.setVisible(false);
        ventana.add(lbl_presentacion8);

        lbl_presentacion9 = new JLabel("02/06/2023\n");
        lbl_presentacion9.setBounds(250, 310, 450, 200);
        lbl_presentacion9.setVisible(false);
        ventana.add(lbl_presentacion9);






        btn_limpiar = new JButton("Limpiar");
        btn_limpiar.setBounds(150,200,90,20);
        btn_limpiar.setVisible(false);
        ventana.add(btn_limpiar);

        btn_buscar = new JButton("Buscar");
        btn_buscar.setBounds(150,225,90,20);
        btn_buscar.setVisible(false);
        ventana.add(btn_buscar);

        btn_adicionar = new JButton("Adicionar");
        btn_adicionar.setBounds(150,250,90,20);
        btn_adicionar.setVisible(false);
        ventana.add(btn_adicionar);

        btn_modificar = new JButton("Modificar");
        btn_modificar.setBounds(150,275,90,20);
        btn_modificar.setVisible(false);
        ventana.add(btn_modificar);

        btn_eliminar = new JButton("Elimininar");
        btn_eliminar.setBounds(150,300,90,20);
        btn_eliminar.setVisible(false);
        ventana.add(btn_eliminar);

        btn_listar = new JButton("Listar");
        btn_listar.setBounds(150,325,90,20);
        btn_listar.setVisible(false);
        ventana.add(btn_listar);




        ventana.setVisible(true);



    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == miSalir)
        {
            System.exit(0);
        }
            
        if(e.getSource()== miPresentacion)
        {
            abrir();
        }

        if(e.getSource() == mmPaciente)
        {
            mostrar();
        }

        if(e.getSource() == mmMedico)
        {
            mostrar();
        }
            
    }

    private void abrir()
    {
        lbl_presentacion1.setVisible(true);
        lbl_presentacion2.setVisible(true);
        lbl_presentacion3.setVisible(true);
        lbl_presentacion4.setVisible(true);
        lbl_presentacion5.setVisible(true);
        lbl_presentacion6.setVisible(true);
        lbl_presentacion7.setVisible(true);
        lbl_presentacion8.setVisible(true);
        lbl_presentacion9.setVisible(true);

    }

    private void mostrar()
    {
        btn_limpiar.setVisible(true);
        btn_buscar.setVisible(true);
        btn_adicionar.setVisible(true);
        btn_modificar.setVisible(true);
        btn_eliminar.setVisible(true);
        btn_listar.setVisible(true);

    }
}
