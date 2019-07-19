package RioCuartoViaja;
import java.util.List;
import org.javalite.activejdbc.*;
import javax.swing.JOptionPane;
import RioCuartoViaja.*;

public class ModificarViaje extends javax.swing.JFrame {


    public ModificarViaje() {
        
        initComponents();
    }

    public boolean buscarDni (String dni){
        Base.open();
        boolean a = false;
        List<Cliente> cliente = Cliente.findAll();
		if(!cliente.isEmpty()){
            for(Cliente i : cliente){
                if (i.getDni().equals(dni)){
                    a = true;
                }
			}
        }
        Base.close();
        return a;
    }
    public void mostrarCampos(String dni){
        Base.open();
        cargarDatosPersonales();
        cargarFichaMedica();
        cargarClientePaquete();
        cargarAtraccionPaquete();
        cargarFormaPago();
        Base.close();
    }
    public void cargarDatosPersonales(){
        int dni = Integer.parseInt(jTextField1.getText());
        String nombre = new String (jTextField2.getText());
        String apellido = new String (jTextField3.getText());
        String direccion = new String (jTextField5.getText());
        String telefono = new String (jTextField4.getText());
        String nombre_agrupacion = new String (jComboBox5.getSelectedItem().toString());
        Cliente nuevoCliente = new Cliente(dni,nombre,apellido,direccion,telefono,nombre_agrupacion);
        nuevoCliente.saveIt();
    }
    public void cargarFichaMedica(){
        int dni = Integer.parseInt(jTextField1.getText());
        String nombre_enfermedad = new String (jTextField6.getText());
        String es_cronica = new String (jTextField7.getText());
        String nombre_medicamento = new String (jTextField8.getText());
        String frecuencia = new String (jTextField9.getText());
        String medicamento_alergico = new String (jTextField10.getText());

        FichaMedica nuevaFicha = new FichaMedica(dni, nombre_enfermedad, es_cronica, nombre_medicamento, frecuencia, medicamento_alergico);
        nuevaFicha.saveIt();
    }

    public void cargarClientePaquete(){

        int dni = Integer.parseInt(jTextField1.getText());  
        String destino = jComboBox1.getSelectedItem().toString();
        PaqueteTuristico dest = PaqueteTuristico.findFirst("ciudad_destino = ?",destino); 
        int id_paquete = Integer.parseInt(dest.getId());
        
        ClientePaquete nuevoClientePaquete = new ClientePaquete(dni, id_paquete);
        nuevoClientePaquete.saveIt();
    }

    public void cargarAtraccionPaquete(){

        String dni = jTextField1.getText(); 
        String destino = jComboBox1.getSelectedItem().toString();
        PaqueteTuristico dest = PaqueteTuristico.findFirst("ciudad_destino = ?",destino); 
        int id_paquete = Integer.parseInt(dest.getId());
        int id_cliente_paquete = 0;
        List<ClientePaquete> clientePaq = ClientePaquete.findAll();
		if(!clientePaq.isEmpty()){
            for(ClientePaquete i : clientePaq){
                if (i.getDni().equals(dni) && i.getIdPaquete().equals(Integer.toString(id_paquete))){
                    id_cliente_paquete =  Integer.parseInt(i.getId());
                }
			}
        }
        int id_atraccion1=0;
        int id_atraccion2=0;
        int id_atraccion3=0;
        String nom_atrac1 = jComboBox2.getSelectedItem().toString();
        String nom_atrac2 = jComboBox3.getSelectedItem().toString();
        String nom_atrac3 = jComboBox4.getSelectedItem().toString();
        List<AtraccionTuristica> atraCli1 = AtraccionTuristica.findAll();
		if(!atraCli1.isEmpty()){
            for(AtraccionTuristica i : atraCli1){
                if (i.getIdPaquete().equals(Integer.toString(id_paquete)) && i.getNombre().equals(nom_atrac1))
                    id_atraccion1 =  Integer.parseInt(i.getId());
                if (i.getIdPaquete().equals(Integer.toString(id_paquete)) && i.getNombre().equals(nom_atrac2))
                    id_atraccion2 =  Integer.parseInt(i.getId());
                if (i.getIdPaquete().equals(Integer.toString(id_paquete)) && i.getNombre().equals(nom_atrac3))
                    id_atraccion3 =  Integer.parseInt(i.getId());
			}
        }
        AtraccionCliente nuevaAtraccionCliente1 = new AtraccionCliente (id_cliente_paquete,id_atraccion1);
        nuevaAtraccionCliente1.saveIt();
        AtraccionCliente nuevaAtraccionCliente2 = new AtraccionCliente (id_cliente_paquete,id_atraccion2);
        nuevaAtraccionCliente2.saveIt();
        AtraccionCliente nuevaAtraccionCliente3 = new AtraccionCliente (id_cliente_paquete,id_atraccion3);
        nuevaAtraccionCliente3.saveIt();
    }

    public void agregarItemComboBoxDestino(){
        Base.open();
        jComboBox1.addItem("");
        List<PaqueteTuristico> paquete = PaqueteTuristico.findAll();
		if(!paquete.isEmpty()){
            for(PaqueteTuristico i : paquete){
                jComboBox1.addItem(i.getDestino());
			}
        }
        Base.close();
    }

    public void agregarItemComboBoxAgrupacion(){
        Base.open();
        jComboBoxAgrupacion.addItem("");
        List<AgrupacionJubilado> agrupacion = AgrupacionJubilado.findAll();
		if(!agrupacion.isEmpty()){
            for(AgrupacionJubilado i : agrupacion){
                jComboBoxAgrupacion.addItem(i.getNombre());
			}
        }
        Base.close();
    }
    
    public void agregarItemComboBoxAtraccion(){    
        Base.open();
        String destino = jComboBox1.getSelectedItem().toString();
        String id_paquete = "";

        List<PaqueteTuristico> paquete = PaqueteTuristico.findAll();
		if(!paquete.isEmpty()){
            for(PaqueteTuristico i : paquete){
                if (i.getDestino().equals(destino)){
                    id_paquete = i.getId();
                    break;
                }
			}
        }
        jComboBox2.removeAllItems();
        jComboBox3.removeAllItems();
        jComboBox4.removeAllItems();
        List<AtraccionTuristica> atraccion = AtraccionTuristica.findAll();
        if(!atraccion.isEmpty()){
            for(AtraccionTuristica i : atraccion){
                if (i.getIdPaquete().equals(id_paquete)){
                    jComboBox2.addItem(i.getNombre());
                    jComboBox3.addItem(i.getNombre());
                    jComboBox4.addItem(i.getNombre());
                }
            }
        }
        Base.close();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setResizable(false);
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jComboBoxAgrupacion = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jPanel2.setBackground(new java.awt.Color(1, 1, 1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Ubuntu Mono", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 83, 0));
        jLabel2.setText("RÍO CUARTO VIAJA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(590, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(70, 70, 70));

        jLabel3.setFont(new java.awt.Font("Ubuntu Mono", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 1, 1));
        jLabel3.setText("REALIZAR CAMBIOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(325, 325, 325)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 96, 0));
        jPanel4.setForeground(new java.awt.Color(255, 96, 0));

        jPanel3.setBackground(new java.awt.Color(76, 76, 76));

        jLabel4.setFont(new java.awt.Font("Ubuntu Mono", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(1, 1, 1));
        jLabel4.setText("DATOS PERSONALES");

        jLabel5.setFont(new java.awt.Font("Ubuntu Mono", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(1, 1, 1));
        jLabel5.setText("DNI");

        jLabel6.setFont(new java.awt.Font("Ubuntu Mono", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(20, 2, 2));
        jLabel6.setText("Nombre");

        jLabel7.setFont(new java.awt.Font("Ubuntu Mono", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(1, 1, 1));
        jLabel7.setText("Apellido");

        jLabel8.setFont(new java.awt.Font("Ubuntu Mono", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(1, 1, 1));
        jLabel8.setText("Dirección");

        jLabel9.setFont(new java.awt.Font("Ubuntu Mono", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(1, 1, 1));
        jLabel9.setText("Telefono");

        jLabel16.setFont(new java.awt.Font("Ubuntu Mono", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(1, 1, 1));
        jLabel16.setText("Agrupación");

        jButton3.setBackground(new java.awt.Color(29, 134, 21));
        jButton3.setFont(new java.awt.Font("Ubuntu Mono", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(1, 1, 1));
        jButton3.setText("BUSCAR");
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.setContentAreaFilled(false);
        jButton3.setOpaque(true);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jComboBoxAgrupacion.setForeground(new java.awt.Color(1, 1, 1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(103, 103, 103)
                            .addComponent(jLabel4))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel8))
                                        .addGap(22, 22, 22)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField4)
                                            .addComponent(jTextField5)
                                            .addComponent(jComboBoxAgrupacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jComboBoxAgrupacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(76, 76, 76));

        jLabel10.setFont(new java.awt.Font("Ubuntu Mono", 1, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(1, 1, 1));
        jLabel10.setText("FICHA MEDICA");

        jLabel11.setFont(new java.awt.Font("Ubuntu Mono", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(1, 1, 1));
        jLabel11.setText("Enfermedad");

        jLabel12.setForeground(new java.awt.Color(1, 1, 1));
        jLabel12.setText("¿ Es cronica ?");

        jLabel13.setFont(new java.awt.Font("Ubuntu Mono", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(1, 1, 1));
        jLabel13.setText("Medicación");

        jLabel14.setFont(new java.awt.Font("Ubuntu Mono", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(1, 1, 1));
        jLabel14.setText("Frecuencia");

        jLabel15.setForeground(new java.awt.Color(1, 1, 1));
        jLabel15.setText("Med.alérgico");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel10))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(76, 76, 76));

        jLabel17.setFont(new java.awt.Font("Ubuntu Mono", 1, 15)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(1, 1, 1));
        jLabel17.setText("PAQUETE TURÍSTICO");

        jLabel18.setFont(new java.awt.Font("Ubuntu Mono", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(1, 1, 1));
        jLabel18.setText("Ciudad de destino");

        jLabel19.setFont(new java.awt.Font("Ubuntu Mono", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(1, 1, 1));
        jLabel19.setText("Atracción túristica 2");

        jLabel21.setFont(new java.awt.Font("Ubuntu Mono", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(1, 1, 1));
        jLabel21.setText("Atracción túristica 1");

        jLabel20.setFont(new java.awt.Font("Ubuntu Mono", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(1, 1, 1));
        jLabel20.setText("Atracción túristica 3");

        jButton4.setBackground(new java.awt.Color(29, 134, 21));
        jButton4.setFont(new java.awt.Font("Ubuntu Mono", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(1, 1, 1));
        jButton4.setText("OK");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.setContentAreaFilled(false);
        jButton4.setOpaque(true);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel18)
                        .addComponent(jLabel21)
                        .addComponent(jLabel19)
                        .addComponent(jLabel20)))
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jButton2.setBackground(new java.awt.Color(245, 2, 2));
        jButton2.setFont(new java.awt.Font("Ubuntu Mono", 1, 15)); // NOI18N
        jButton2.setForeground(new java.awt.Color(1, 1, 1));
        jButton2.setText("CANCELAR");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setContentAreaFilled(false);
        jButton2.setOpaque(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(29, 134, 21));
        jButton1.setFont(new java.awt.Font("Ubuntu Mono", 1, 15)); // NOI18N
        jButton1.setForeground(new java.awt.Color(1, 1, 1));
        jButton1.setText("ACEPTAR");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setContentAreaFilled(false);
        jButton1.setDefaultCapable(false);
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(92, 92, 92))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(512, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 91, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        agregarItemComboBoxDestino();
        agregarItemComboBoxAtraccion();
        agregarItemComboBoxAgrupacion();
        pack();
        setSize(880,560);
    }// END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        Inicio inc = new Inicio();
        inc.jLabel5.setText(this.nombreAdmin);
        inc.setVisible(true);
        this.setVisible(false);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        String dni = new String (jTextField2.getText());
        if (buscarDni(dni))
            mostrarCampos(dni);
        else
            JOptionPane.showMessageDialog(null, "DNI INCORRECTO");
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        agregarItemComboBoxAtraccion();
    } 

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ModificarViaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarViaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarViaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarViaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarViaje().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBoxAgrupacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    protected String nombreAdmin;
}
