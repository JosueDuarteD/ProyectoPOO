package simuladorcuartofrioindustrial.InterfazGrafica;

import simuladorcuartofrioindustrial.Gestores.GestorPersistenciaSensores;
import simuladorcuartofrioindustrial.Gestores.GestorArchivos;
import simuladorcuartofrioindustrial.Excepciones.ParametroFueraDeRangoException;
import simuladorcuartofrioindustrial.Sensores.SensorTemperatura;
import simuladorcuartofrioindustrial.Sensores.SensorPuerta;
import simuladorcuartofrioindustrial.Sensores.SensorPresion;
import simuladorcuartofrioindustrial.Sensores.Sensor;

public class ConfiguracionCuarto extends javax.swing.JPanel {
    
    private ControladorInterfaces framePrincipal;

    public ConfiguracionCuarto(ControladorInterfaces framePrincipal) {
        this.framePrincipal = framePrincipal;
        initComponents();
        tablaObjetos.setFillsViewportHeight(true);
        restaurarTablas();
        actualizarRangoSpinnerEliminar();
    }
    
    private void cargarTablaObjetos() {
        
        if (tablaObjetos.getModel() == null || !(tablaObjetos.getModel() instanceof javax.swing.table.DefaultTableModel)) {
            tablaObjetos.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {},
                new String[] { "ID", "Nombre", "Límite Inferior", "Límite Superior", "Valor Actual" }
            ));
        }
        
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tablaObjetos.getModel();
        modelo.setRowCount(0);

        try {
            if (framePrincipal != null && framePrincipal.getGestorSensores() != null) {
            
                java.util.ArrayList<Sensor> sensores = framePrincipal.getGestorSensores().getSensores();
            
                if (sensores != null) {
                    for (Sensor sensor : sensores) {
                        
                        Object limInferior = sensor.getLimiteInferior();
                        Object limSuperior = sensor.getLimiteSuperior();
                        
                        if (sensor instanceof SensorPuerta) {
                        limInferior = 0;
                        limSuperior = 1;
                    }
                        
                        modelo.addRow(new Object[]{
                            sensor.getId(),
                            sensor.getNombre(),
                            limInferior,
                            limSuperior,
                            sensor.getValorActual()
                        });
                    }
                }
            }
            tablaObjetos.revalidate();
            tablaObjetos.repaint();
        } catch (Exception e) {
            System.out.println("Aviso: No se pudieron cargar los sensores en la tabla todavía: " + e.getMessage());
        }
    }
    
    private void cargarTablaArchivos() {
    javax.swing.table.DefaultTableModel modeloArchivos = (javax.swing.table.DefaultTableModel) tablaArchivos.getModel();
    modeloArchivos.setRowCount(0); // Limpiamos la tabla de inmediato

    String rutaTxt = "sin_nombre.txt";
    String rutaBin = "sin_nombre.bin";
    boolean huboCambioBinario = false;

    try {
            if (framePrincipal != null) {
            
                if (framePrincipal.getGestorArchivos() != null) {
                    String archivoTxt = framePrincipal.getGestorArchivos().getArchivo();
                    if (archivoTxt != null && !archivoTxt.trim().isEmpty()) {
                        rutaTxt = archivoTxt;
                    }
                }
            
                if (framePrincipal.getGestorPersistencia() != null) {
                    String archivoBin = framePrincipal.getGestorPersistencia().getArchivo();
                    if (archivoBin != null && !archivoBin.trim().isEmpty()) {
                        rutaBin = archivoBin;
                        huboCambioBinario = true;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Aviso: No se pudieron extraer las rutas de los gestores aún: " + e.getMessage());
        }
        modeloArchivos.addRow(new Object[]{ rutaTxt, rutaBin });
        actualizarRangoSpinnerEliminar();
    }
    
    private void actualizarRangoSpinnerEliminar(){
        if (framePrincipal != null && framePrincipal.getGestorSensores() != null) {
            int totalSensores = framePrincipal.getGestorSensores().getSensores().size();
            
            if (totalSensores > 0) {
                selectorPosicionEliminar.setModel(new javax.swing.SpinnerNumberModel(1, 1, totalSensores, 1));
                selectorPosicionEliminar.setEnabled(true);
                eliminarSensor.setEnabled(true);
            } else {
                selectorPosicionEliminar.setModel(new javax.swing.SpinnerNumberModel(0, 0, 0, 1));
                selectorPosicionEliminar.setEnabled(false);
                eliminarSensor.setEnabled(false);
            }
        }
    }
    
    public void restaurarTablas() {
        cargarTablaObjetos();
        cargarTablaArchivos();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaObjetos = new javax.swing.JTable();
        guardarConfiguracion = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaArchivos = new javax.swing.JTable();
        selectorSensor = new javax.swing.JComboBox<>();
        selectorCantidadSensores = new javax.swing.JSpinner();
        agregarSensor = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        selectorPosicionEliminar = new javax.swing.JSpinner();
        eliminarSensor = new javax.swing.JButton();
        vaciarSensores = new javax.swing.JButton();

        setBackground(new java.awt.Color(60, 98, 85));
        setForeground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(700, 500));

        tablaObjetos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        tablaObjetos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Mínimo", "Máximo", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaObjetos);

        guardarConfiguracion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        guardarConfiguracion.setText("Guardar configuraciones");
        guardarConfiguracion.addActionListener(this::guardarConfiguracionActionPerformed);

        tablaArchivos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        tablaArchivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Nombre archivo.txt", "Nombre archivo.bin"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaArchivos);

        selectorSensor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        selectorSensor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sensor de Temperatura", "Sensor de Presion", "Sensor de Puerta" }));
        selectorSensor.addActionListener(this::selectorSensorActionPerformed);

        selectorCantidadSensores.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));

        agregarSensor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        agregarSensor.setText("Agregar a la lista");
        agregarSensor.addActionListener(this::agregarSensorActionPerformed);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre de los archivos");
        jLabel1.setPreferredSize(new java.awt.Dimension(290, 16));

        jLabel2.setBackground(new java.awt.Color(60, 98, 85));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Agregar sensores (Cuidado de no pasarte)");
        jLabel2.setOpaque(true);
        jLabel2.setPreferredSize(new java.awt.Dimension(340, 16));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Parámetros");
        jLabel3.setPreferredSize(new java.awt.Dimension(314, 16));

        selectorPosicionEliminar.setModel(new javax.swing.SpinnerNumberModel(1, null, null, 1));

        eliminarSensor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        eliminarSensor.setText("Eliminar Sensor numero -->");
        eliminarSensor.addActionListener(this::eliminarSensorActionPerformed);

        vaciarSensores.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        vaciarSensores.setText("Vaciar lista de sensores");
        vaciarSensores.addActionListener(this::vaciarSensoresActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(eliminarSensor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectorPosicionEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(vaciarSensores, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guardarConfiguracion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(selectorSensor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectorCantidadSensores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(agregarSensor)
                        .addGap(52, 52, 52)))
                .addGap(0, 124, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 315, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(315, 315, 315))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 235, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(235, 235, 235))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectorSensor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectorCantidadSensores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregarSensor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vaciarSensores)
                    .addComponent(selectorPosicionEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminarSensor))
                .addGap(0, 0, 0)
                .addComponent(guardarConfiguracion)
                .addContainerGap(124, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void guardarConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarConfiguracionActionPerformed
        
        if (tablaObjetos.isEditing()) {
            tablaObjetos.getCellEditor().stopCellEditing();
        }
        if (tablaArchivos.isEditing()) {
            tablaArchivos.getCellEditor().stopCellEditing();
        }
        
        if (framePrincipal == null || framePrincipal.getGestorSensores() == null) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "El gestor de sensores no está listo.",
                "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        javax.swing.table.DefaultTableModel modeloObjetos = (javax.swing.table.DefaultTableModel) tablaObjetos.getModel();
        javax.swing.table.DefaultTableModel modeloArchivos = (javax.swing.table.DefaultTableModel) tablaArchivos.getModel();
        
        java.util.ArrayList<Sensor> listaSensores = framePrincipal.getGestorSensores().getSensores();
        
        String nuevoTxt = "";
        String nuevoBin = "";
    
        try {
            for (int i = 0; i < modeloObjetos.getRowCount(); i++) {
                String nuevoId = modeloObjetos.getValueAt(i, 0).toString().trim();
                String nuevoNombre = modeloObjetos.getValueAt(i, 1).toString().trim();
                double limInferior = Double.parseDouble(modeloObjetos.getValueAt(i, 2).toString());
                double limSuperior = Double.parseDouble(modeloObjetos.getValueAt(i, 3).toString());
                double valActual = Double.parseDouble(modeloObjetos.getValueAt(i, 4).toString());
                
                if (nuevoId.isEmpty() || nuevoNombre.isEmpty()) {
                    throw new IllegalArgumentException("Tabla Sensores - Fila " + (i + 1) + ": El ID y el Nombre del sensor no pueden estar vacíos.");
                }

                if (limInferior >= limSuperior) {
                    throw new ParametroFueraDeRangoException(
                        "Tabla Sensores - Fila " + (i + 1) + ": El límite inferior no puede ser mayor o igual al superior."
                    );
                }
                if (i < listaSensores.size()) {
                    
                    Sensor sensor = listaSensores.get(i);
                    
                    if (sensor instanceof SensorPuerta) {
                        if (limInferior != 0.0 || limSuperior != 1.0) {
                            throw new IllegalArgumentException(
                                "Tabla Sensores - Fila " + (i + 1) + " (" + sensor.getNombre() + "):\n" +
                                "No está permitido modificar los límites de un Sensor de Puerta.\n" +
                                "Deben permanecer estrictamente en Mínimo: 0.0 y Máximo: 1.0."
                            );
                        }
                    }
                    
                    sensor.setId(nuevoId);
                    sensor.setNombre(nuevoNombre);
                    sensor.setValorActual(valActual);
                    
                    if (!(sensor instanceof SensorPuerta)) {
                        if (limInferior < sensor.getLimiteSuperior()) {
                        sensor.setLimiteInferior(limInferior);
                        sensor.setLimiteSuperior(limSuperior);
                    } else if (limSuperior > sensor.getLimiteInferior()) {
                        sensor.setLimiteSuperior(limSuperior);
                        sensor.setLimiteInferior(limInferior);
                    } else {
                        sensor.setLimiteSuperior(Double.MAX_VALUE); 
                        sensor.setLimiteInferior(limInferior);
                        sensor.setLimiteSuperior(limSuperior);
                    }
                    }
                }
            }

            framePrincipal.getGestorSensores().actualizarListaSensores(listaSensores);
            
            if (modeloArchivos.getRowCount() > 0) {
                nuevoTxt = modeloArchivos.getValueAt(0, 0).toString().trim();
                nuevoBin = modeloArchivos.getValueAt(0, 1).toString().trim(); 

                if (nuevoTxt.isEmpty() || nuevoBin.isEmpty()) {
                    throw new IllegalArgumentException("Los nombres de los archivos de texto o binarios no pueden estar vacíos.");
                }

                if (!nuevoTxt.endsWith(".txt")) {
                    throw new IllegalArgumentException("El archivo de reporte debe incluir la extensión '.txt'");
                }
                if (!nuevoBin.endsWith(".bin")) {
                    throw new IllegalArgumentException("El archivo binario debe incluir la extensión '.bin'");
                }
            }

            framePrincipal.setGestorArchivos(new GestorArchivos(nuevoTxt));
            framePrincipal.setGestorPersistencia(new GestorPersistenciaSensores(nuevoBin));

            javax.swing.JOptionPane.showMessageDialog(this,
                "¡Rutas de archivos guardadas en el sistema!\nLos cambios de los sensores quedan preparados en borrador.",
                "Configuración Guardada", javax.swing.JOptionPane.INFORMATION_MESSAGE);

        } catch (ParametroFueraDeRangoException ex) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Error de coherencia en los rangos:\n" + ex.getMessage(),
                "Operación Cancelada", javax.swing.JOptionPane.ERROR_MESSAGE);
            restaurarTablas();

        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Error: Has introducido texto en un campo numérico (límites o valor actual).",
                "Error de Formato", javax.swing.JOptionPane.ERROR_MESSAGE);
            restaurarTablas();

        } catch (IllegalArgumentException ex) {
            javax.swing.JOptionPane.showMessageDialog(this,
                ex.getMessage(),
                "Campos Incorrectos", javax.swing.JOptionPane.WARNING_MESSAGE);
            restaurarTablas();
        }
    }//GEN-LAST:event_guardarConfiguracionActionPerformed

    private void selectorSensorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectorSensorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectorSensorActionPerformed

    private void agregarSensorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarSensorActionPerformed
        
        if (framePrincipal == null || framePrincipal.getGestorSensores() == null) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "El gestor de sensores aún no está listo.", 
                "Error de Inicialización", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String tipoSeleccionado = selectorSensor.getSelectedItem().toString();
        int cantidad = (int) selectorCantidadSensores.getValue();
        
        java.util.ArrayList<Sensor> listaSensores = framePrincipal.getGestorSensores().getSensores();
        
        try {
            for (int i = 0; i < cantidad; i++) {
                int numeroSiguiente = listaSensores.size() + 1;
                Sensor nuevoSensor = null;

                switch (tipoSeleccionado) {
                    case "Sensor de Temperatura":
                        nuevoSensor = new SensorTemperatura("TEMP-" + numeroSiguiente, "Temp " + numeroSiguiente, 0, 1);
                        break;

                    case "Sensor de Puerta":
                            nuevoSensor = new SensorPuerta("PUER-" + numeroSiguiente, "Puerta " + numeroSiguiente);
                        break;

                    case "Sensor de Presion":
                        nuevoSensor = new SensorPresion("PRES-" + numeroSiguiente, "Presión " + numeroSiguiente, 0, 1);
                        break;
                }

                if (nuevoSensor != null) {
                    listaSensores.add(nuevoSensor);
                }
            }

            framePrincipal.getGestorSensores().actualizarListaSensores(listaSensores);
            cargarTablaObjetos();
            actualizarRangoSpinnerEliminar();

            javax.swing.JOptionPane.showMessageDialog(this, 
                "Se han agregado " + cantidad + " sensores de " + tipoSeleccionado + " correctamente.",
                "Sensores Creados", javax.swing.JOptionPane.INFORMATION_MESSAGE);

        } catch (ParametroFueraDeRangoException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al establecer límites por defecto: " + ex.getMessage());
        }
    }//GEN-LAST:event_agregarSensorActionPerformed

    private void eliminarSensorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarSensorActionPerformed
        
        if (framePrincipal == null || framePrincipal.getGestorSensores() == null) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "El gestor de sensores no está listo.", 
                "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        java.util.ArrayList<Sensor> listaSensores = framePrincipal.getGestorSensores().getSensores();

        if (listaSensores.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "No hay sensores en la lista para eliminar.", 
                "Lista Vacía", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        int posicionAEliminar = (int) selectorPosicionEliminar.getValue() - 1;

        try {
            if (posicionAEliminar >= 0 && posicionAEliminar < listaSensores.size()) {
                Sensor removido = listaSensores.remove(posicionAEliminar);
                framePrincipal.getGestorSensores().actualizarListaSensores(listaSensores);
                cargarTablaObjetos();
                actualizarRangoSpinnerEliminar();

                javax.swing.JOptionPane.showMessageDialog(this, 
                    "Sensor '" + removido.getNombre() + "' (ID: " + removido.getId() + ") eliminado correctamente.",
                    "Sensor Eliminado", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Error al eliminar el sensor: " + e.getMessage(), 
                "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_eliminarSensorActionPerformed

    private void vaciarSensoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vaciarSensoresActionPerformed
        if (framePrincipal == null || framePrincipal.getGestorSensores() == null) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "El gestor de sensores no está listo.", 
                "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        java.util.ArrayList<Sensor> listaSensores = framePrincipal.getGestorSensores().getSensores();

        if (listaSensores.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "La lista de sensores ya se encuentra vacía.", 
                "Aviso", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int respuesta = javax.swing.JOptionPane.showConfirmDialog(this,
            "¿Estás seguro de que deseas eliminar TODOS los sensores de la lista?",
            "Confirmar Vaciado",
            javax.swing.JOptionPane.YES_NO_OPTION,
            javax.swing.JOptionPane.WARNING_MESSAGE);

        if (respuesta == javax.swing.JOptionPane.YES_OPTION) {
            listaSensores.clear();
            framePrincipal.getGestorSensores().actualizarListaSensores(listaSensores);

            cargarTablaObjetos();
            actualizarRangoSpinnerEliminar();
            
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Se han removido todos los sensores correctamente.", 
                "Lista Vaciada", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_vaciarSensoresActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarSensor;
    private javax.swing.JButton eliminarSensor;
    private javax.swing.JButton guardarConfiguracion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner selectorCantidadSensores;
    private javax.swing.JSpinner selectorPosicionEliminar;
    private javax.swing.JComboBox<String> selectorSensor;
    private javax.swing.JTable tablaArchivos;
    private javax.swing.JTable tablaObjetos;
    private javax.swing.JButton vaciarSensores;
    // End of variables declaration//GEN-END:variables

}
