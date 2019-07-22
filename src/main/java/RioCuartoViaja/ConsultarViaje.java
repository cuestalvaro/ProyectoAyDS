package RioCuartoViaja;

import java.util.LinkedList;
import java.util.List;
import org.javalite.activejdbc.*;
import javax.swing.JOptionPane;
import RioCuartoViaja.*;
/**
 * clase para buscar y consultar datos de
 * los clientes que estan en la base de datos 
 * @author Álvaro Cuesta
 * 
 */
public class ConsultarViaje extends javax.swing.JFrame {

    /**
     * Constructor de ConsultarViaje
     */
    public ConsultarViaje() {
        initComponents();
    }

    /**
     * Metodo que dice si un dni existe
     * @param dni del cliente
     * @return true si el dni pertenece algun clietne false lo contrario
     */
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

    /**
     * Metodo para buscar los datos de los clientes 
     * y mostrarlo para modificarlos
     * @param dni dni de la persona a buscar
     */
    public void buscarDatos (String dni){
        Base.open();
        buscarCliente(dni);
        buscarFichaMedica(dni);
        buscarClientePaquete(dni);
        Base.close();
    }
    /**
     * Metoodo para buscar datos personales del cliente 
     * @param dni dni del clientes a buscar
     */
    public void buscarCliente (String dni){
        List<Cliente> abu = Cliente.findAll();
		if(!abu.isEmpty()){
            for(Cliente i : abu){
                if (i.getDni().equals(dni)){
                    jLabel4.setText(i.getNombre());
                    jLabel11.setText(i.getApellido());
                    jLabel18.setText(i.getDni());
                    jLabel25.setText(i.getTelefono());
                    jLabel24.setText(i.getDireccion());
                    jLabel26.setText(i.getNombreAgrupacion());
                    break;
                }
			}
        }
    }
    /**
     * Metodo para buscar datos de fincha medica del cliente
     * @param dni dni del cliente a buscar
     */
    public void buscarFichaMedica (String dni){
        List<FichaMedica> ficha = FichaMedica.findAll();
		if(!ficha.isEmpty()){
            for(FichaMedica i : ficha){
                if (i.getDni().equals(dni)){
                    jLabel28.setText(i.getNombreEnfermedad());
                    jLabel29.setText(i.getEsCronica());
                    jLabel27.setText(i.getNombreMedicamento());
                    jLabel30.setText(i.getFrecuencia());
                    jLabel31.setText(i.getMedicamentoAlergico());
                    break;
                }
			}
        }
    }
    /**
     * Metodo para buscar datos del paquete y atraccion
     * del cliente 
     * @param dniString dni del cliente a buscar
     */
    public void buscarClientePaquete(String dniString){
        //destino
        int dni = Integer.parseInt(dniString);
        ClientePaquete cliente = ClientePaquete.findFirst("dni = ?",dni);
        int id_paquete = Integer.parseInt(cliente.getIdPaquete()); 
        int id_cliente_paquete = Integer.parseInt(cliente.getId()); 
        PaqueteTuristico dest = PaqueteTuristico.findFirst("id = ?",id_paquete);
        jLabel23.setText(dest.getDestino());
        //Atracciones
        List<AtraccionCliente> listAtra = AtraccionCliente.where("id_cliente_paquete = ?",id_cliente_paquete);
        AtraccionTuristica atraccion1 = AtraccionTuristica.findFirst("id = ?",Integer.parseInt(listAtra.get(0).getIdAtraccion())); 
        jLabel33.setText(atraccion1.getNombre()); 
        AtraccionTuristica atraccion2 = AtraccionTuristica.findFirst("id = ?",Integer.parseInt(listAtra.get(1).getIdAtraccion())); 
        jLabel32.setText(atraccion2.getNombre()); 
        AtraccionTuristica atraccion3 = AtraccionTuristica.findFirst("id = ?",Integer.parseInt(listAtra.get(2).getIdAtraccion())); 
        jLabel34.setText(atraccion3.getNombre()); 
        //forma de pago efectivo
        List<Efectivo> pagoEfectivo = Efectivo.findAll();
		if(!pagoEfectivo.isEmpty()){
            for(Efectivo i : pagoEfectivo){
                if (i.getIdPaquete().equals(Integer.toString(id_cliente_paquete))){
                    jLabel20.setText("Efectivo");
                    jLabel43.setText("$"+i.getMontoDescuento());
                    jLabel37.setText("Fecha: "+i.getFecha());
                    jLabel22.setText("");
                    jLabel40.setText("");
                    jLabel45.setText("");
                    jLabel35.setText("");
                    jLabel41.setText("");
                    jLabel44.setText("");
                    break;
                }
			}
        }
        //forma de pago efectivo
        List<PlanCuota> pagoCuota = PlanCuota.findAll();
		if(!pagoCuota.isEmpty()){
            for(PlanCuota i : pagoCuota){
                if (i.getIdPaquete().equals(Integer.toString(id_cliente_paquete))){
                    jLabel43.setText(montoCuota(i.getNroPlan()));
                    jLabel20.setText("Cuotas");
                    jLabel42.setText("Monto por Cuota:");
                    jLabel35.setText(i.getCantCoutas());
                    jLabel41.setText(i.getFechaInc());
                    jLabel44.setText(i.getFechaFin());
                    jLabel22.setText("Cant.Cuotas:");
                    jLabel40.setText("Fecha inc.:");
                    jLabel45.setText("Fecha Fin.:");
                    jLabel37.setText("(Si la forma de pago es en cuotas)");
                    break;
                }
			}
        }

    }
    /**
     * metodo que retorna el monto de la cuota
     * del cliente
     * @param nro_plan nro_plan de la cuota
     * @return monto de la cuota
     */
    public String montoCuota (String nro_plan){
        List<Cuota> pcuota = Cuota.findAll();
		if(!pcuota.isEmpty()){
            for(Cuota i : pcuota){
                if (i.getNroPlan().equals(nro_plan)){
                    return i.getMonto();
                }

            }
        }
        return "";
    }

    //--------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------
    
    @SuppressWarnings("unchecked")
    private void initComponents() {

        setResizable(false);
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(70, 70, 70));

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
                .addContainerGap(582, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Ubuntu Mono", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(1, 1, 1));
        jLabel5.setText("BUSCAR DATOS");

        jPanel4.setBackground(new java.awt.Color(255, 96, 0));
        jPanel4.setForeground(new java.awt.Color(255, 96, 0));

        jPanel3.setBackground(new java.awt.Color(76, 76, 76));

        jLabel6.setForeground(new java.awt.Color(1, 1, 1));
        jLabel6.setText("Nombre: ");

        jLabel7.setForeground(new java.awt.Color(20, 2, 2));
        jLabel7.setText("Apellido:");

        jLabel8.setForeground(new java.awt.Color(1, 1, 1));
        jLabel8.setText("DNI:");

        jLabel9.setForeground(new java.awt.Color(1, 1, 1));
        jLabel9.setText("Dirección:");

        jLabel10.setForeground(new java.awt.Color(1, 1, 1));
        jLabel10.setText("Telefono:");

        jLabel16.setForeground(new java.awt.Color(1, 1, 1));
        jLabel16.setText("Agrupación:");

        jLabel12.setForeground(new java.awt.Color(1, 1, 1));
        jLabel12.setText("Enfermedad:");

        jLabel13.setForeground(new java.awt.Color(1, 1, 1));
        jLabel13.setText("¿ Es cronica ?:");

        jLabel14.setForeground(new java.awt.Color(1, 1, 1));
        jLabel14.setText("Medicación:");

        jLabel15.setForeground(new java.awt.Color(1, 1, 1));
        jLabel15.setText("Frecuencia:");

        jLabel17.setForeground(new java.awt.Color(1, 1, 1));
        jLabel17.setText("Med.alérgico:");

        jLabel4.setFont(new java.awt.Font("Ubuntu Mono", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(4, 2, 2));
        jLabel4.setText("");

        jLabel11.setFont(new java.awt.Font("Ubuntu Mono", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(4, 2, 2));
        jLabel11.setText("");

        jLabel18.setFont(new java.awt.Font("Ubuntu Mono", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(4, 2, 2));
        jLabel18.setText("");

        jLabel24.setFont(new java.awt.Font("Ubuntu Mono", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(4, 2, 2));
        jLabel24.setText("");

        jLabel25.setFont(new java.awt.Font("Ubuntu Mono", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(4, 2, 2));
        jLabel25.setText("");

        jLabel26.setFont(new java.awt.Font("Ubuntu Mono", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(4, 2, 2));
        jLabel26.setText("");

        jLabel27.setFont(new java.awt.Font("Ubuntu Mono", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(4, 2, 2));
        jLabel27.setText("");

        jLabel28.setFont(new java.awt.Font("Ubuntu Mono", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(4, 2, 2));
        jLabel28.setText("");

        jLabel29.setFont(new java.awt.Font("Ubuntu Mono", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(4, 2, 2));
        jLabel29.setText("");

        jLabel30.setFont(new java.awt.Font("Ubuntu Mono", 0, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(4, 2, 2));
        jLabel30.setText("");

        jLabel31.setFont(new java.awt.Font("Ubuntu Mono", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(4, 2, 2));
        jLabel31.setText("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel26))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel28))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel29))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel30))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel31)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel31))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(76, 76, 76));

        jLabel3.setFont(new java.awt.Font("Ubuntu Mono", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 1, 1));
        jLabel3.setText("DNI DEL TITULAR");

        jButton1.setBackground(new java.awt.Color(29, 134, 21));
        jButton1.setFont(new java.awt.Font("Ubuntu Mono", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(1, 1, 1));
        jButton1.setText("BUSCAR");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setContentAreaFilled(false);
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addGap(48, 48, 48)
                .addComponent(jButton1)
                .addGap(0, 132, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(0, 26, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(76, 76, 76));

        jLabel19.setForeground(new java.awt.Color(1, 1, 1));
        jLabel19.setText("Destino:");

        jLabel20.setFont(new java.awt.Font("Ubuntu Mono", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(4, 2, 2));
        jLabel20.setText("");

        jLabel21.setForeground(new java.awt.Color(1, 1, 1));
        jLabel21.setText("Atracciones:");

        jLabel22.setForeground(new java.awt.Color(1, 1, 1));
        jLabel22.setText("Cant.Cuotas:");

        jLabel23.setFont(new java.awt.Font("Ubuntu Mono", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(4, 2, 2));
        jLabel23.setText("");

        jLabel32.setFont(new java.awt.Font("Ubuntu Mono", 0, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(4, 2, 2));
        jLabel32.setText("");

        jLabel33.setFont(new java.awt.Font("Ubuntu Mono", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(4, 2, 2));
        jLabel33.setText("");

        jLabel34.setFont(new java.awt.Font("Ubuntu Mono", 0, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(4, 2, 2));
        jLabel34.setText("");

        jLabel35.setFont(new java.awt.Font("Ubuntu Mono", 0, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(1, 1, 1));
        jLabel35.setText("");

        jLabel37.setForeground(new java.awt.Color(1, 1, 1));
        jLabel37.setText("(Si la forma de pago es en cuotas)");

        jLabel39.setForeground(new java.awt.Color(1, 1, 1));
        jLabel39.setText("Forma pago:");

        jLabel42.setForeground(new java.awt.Color(1, 1, 1));
        jLabel42.setText("Monto:");

        jLabel43.setFont(new java.awt.Font("Ubuntu Mono", 0, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(1, 1, 1));
        jLabel43.setText("");

        jLabel40.setForeground(new java.awt.Color(1, 1, 1));
        jLabel40.setText("Fecha inc.:");

        jLabel41.setFont(new java.awt.Font("Ubuntu Mono", 0, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(1, 1, 1));
        jLabel41.setText("");

        jLabel44.setFont(new java.awt.Font("Ubuntu Mono", 0, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(1, 1, 1));
        jLabel44.setText("");

        jLabel45.setForeground(new java.awt.Color(1, 1, 1));
        jLabel45.setText("Fecha Fin.:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel32)
                                    .addComponent(jLabel33)))
                            .addComponent(jLabel37)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addComponent(jLabel34)))
                        .addContainerGap(39, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel23))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel39)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel20))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel43))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel40)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel45))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel44)
                                    .addComponent(jLabel41)
                                    .addComponent(jLabel35))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel23))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jLabel43))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(jLabel22))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41)
                            .addComponent(jLabel40))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel45)
                        .addComponent(jLabel44)))
                .addContainerGap())
        );

        jButton2.setBackground(new java.awt.Color(29, 134, 21));
        jButton2.setFont(new java.awt.Font("Ubuntu Mono", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(1, 1, 1));
        jButton2.setText("LISTO");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setContentAreaFilled(false);
        jButton2.setOpaque(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(322, 322, 322)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(435, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(0, 108, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String dni = new String (jTextField1.getText());
        if (dni.equals("") ) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese DNI");
        }
        else if (!buscarDni(dni))
            JOptionPane.showMessageDialog(null, "DNI incorrecto");
        else{
            buscarDatos(dni);
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Inicio inc = new Inicio();
        inc.jLabel5.setText(this.nombreAdmin);
        inc.setVisible(true);
        this.setVisible(false);
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
            java.util.logging.Logger.getLogger(ConsultarViaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarViaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarViaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarViaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarViaje().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
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
    protected String nombreAdmin;
    // End of variables declaration//GEN-END:variables
}
