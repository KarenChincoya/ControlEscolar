package velasco.karen.view;

import java.awt.BorderLayout;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import sun.applet.Main;
import velasco.karen.DAO.AlumnoDAO;
import velasco.karen.objects.Alumno;

public class MainFrame extends JFrame {
	private AlumnoInsertDlg dlgEstudiante;
	private EncabezadoPnl pnlEncabezado;
	private AlumnoTabla tablaAlumnos;
	private AlumnoInsertDlg dlgInsert;
	private AlumnoUpdateDlg dlgUpdate;
	private AlumnoUpdateDlg2 dlgUpdate2;
	private AlumnoSelectDlg dlgSelect;
	private AlumnoDeleteDlg dlgDelete;
	private OpcionesDlg dlgOpciones;
	private AlumnoDeleteDlgV2 dlgDelete2;

	private AlumnoDAO daoAlumno;
	private ArrayList<Alumno> alumnos;
	private Alumno alumno;
	private String buscar;
	private Integer selectedStudent;

	public Integer cont;

	public MainFrame() {
		super("Universidad La Salle Oaxaca");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setLayout(new BorderLayout());
		super.setSize(1200, 500);

		dlgInsert = new AlumnoInsertDlg(this);
		dlgSelect = new AlumnoSelectDlg(this);
//		dlgUpdate = new AlumnoUpdateDlg(this);
		dlgDelete = new AlumnoDeleteDlg(this);
//		dlgDelete2 = new AlumnoDeleteDlgV2(this);
		dlgOpciones = new OpcionesDlg(this);

		// Controlador
		daoAlumno = new AlumnoDAO();
		alumnos = daoAlumno.getAlumnos("");
		// Elementos graficos principales
		pnlEncabezado = new EncabezadoPnl();
		tablaAlumnos = new AlumnoTabla(alumnos);
		cont = 0;
		tablaAlumnos.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				String s = String.valueOf(arg0.getSource().toString());
				System.out.println(s);
				String[] tokens = s.split("[{|}]");
				Integer ss = Integer.valueOf(tokens[1]);
		
				MainFrame.this.setSelectedStudent(ss);
				System.out.println(MainFrame.this.getSelectedStudent());
				
				String l = String.valueOf(tablaAlumnos.getAlumnoTableModel().getValueAt(ss, 0));
				
				System.out.println("Id seleccionado= "+l);
				
				MainFrame.this.setSelectedStudent(Integer.valueOf(l));
			}
		});

		// Dlgs

		pnlEncabezado.setListener(new EncabezadoListener() {
			@Override
			public void onBtnClick(Integer opcion) {
				// TODO Auto-generated method stub
				System.out.println("MainFrame ----> opcion = " + opcion);
				switch (opcion) {
				case 1:// agregar
					System.out.println("Eligio insertar un estudiante");
					dlgInsert.setListener(new AlumnoInsertListener() {
						@Override
						public void onBtnClick(String id, String nombre, String apellido1, String apellido2,
								String fecha, Integer carrera) {
							// TODO Auto-generated method stub
							try {
								Integer numId = Integer.valueOf(id);
								Date date = Date.valueOf(fecha);
								daoAlumno.insertStudent(numId, nombre, apellido1, apellido2, carrera, date);
								MainFrame.this.revalidateTable();
							} catch (Exception e) {
								// TODO: handle exception
								e.printStackTrace();
								System.out.println("Recuerde: el id es un numero. Debe elegir una fecha.");
							}
						}
					});
					dlgInsert.setVisible(true);
					break;
				case 2:// actualizar
					System.out.println("Eligio actualizar");
					//dlgUpdate.setListener(new AlumnoUpdateListener() {

						//@Override
						//public void onBtnClick(Integer id) {
							// buscar el alumno con ese id
							try {
								String str1 = String.valueOf(MainFrame.this.getSelectedStudent());
								System.out.println(str1);
								
								alumno = daoAlumno.getAlumnos(str1.trim()).get(0);
								
								dlgUpdate2 = new AlumnoUpdateDlg2(MainFrame.this, alumno);
								
								dlgUpdate2.setListener(new AlumnoUpdateListener2() {

									@Override
									public void onBtnClick(String id, String nombre, String apellido1, String apellido2,
											String fecha, Integer carrera) {
										// TODO Auto-generated method stub
										try {
											Integer numId = Integer.valueOf(id);
											Date date = Date.valueOf(fecha);
											daoAlumno.updateStudent(numId, nombre, apellido1, apellido2, carrera, date);
											MainFrame.this.revalidateTable();
										} catch (Exception e) {
											// TODO: handle exception
											e.printStackTrace();
											System.out.println("Recuerde: el id es un numero. Debe elegir una fecha.");
										}
									}
								});
							} catch (Exception e) {
								// TODO: handle exception
							}
							dlgUpdate2.setVisible(true);
					//	}
					//});
					//dlgUpdate.setVisible(true);
					break;
				case 4:// buscar
					dlgSelect.setListener(new AlumnoSelectListener() {
						@Override
						public void onBtnClick(String buscar) {
							// TODO Auto-generated method stub
							if (buscar == null) {
								MainFrame.this.revalidateTable();
							} else {
								System.out.println("Texto a buscar: " + buscar);
								MainFrame.this.revalidateTable(buscar);
							}
						}
					});
					dlgSelect.setVisible(true);
					break;
				case 3: // eliminar, dlgDelete2
					dlgDelete.setListener(new AlumnoDeleteListener() {

						@Override
						public void onBtnClick() {
							// TODO Auto-generated method stub
							daoAlumno.deleteStudent(MainFrame.this.getSelectedStudent());
							MainFrame.this.revalidateTable();
							
						}
					});
					dlgDelete.setVisible(true);
					break;
				case 5:
					MainFrame.this.revalidateTable();
					break;
				default:
					System.out.println("Error de entrada.");
				}
			}
		});

		super.add(pnlEncabezado, BorderLayout.NORTH);
		super.add(tablaAlumnos, BorderLayout.CENTER);
		super.setVisible(true);
	}

	public void revalidateTable() {
		alumnos = daoAlumno.getAlumnos("");
		this.tablaAlumnos.setoAlumnos(alumnos);
		this.tablaAlumnos.revalidate();
		this.tablaAlumnos.repaint();
		System.out.println("Alumnos revalidados");
	}

	public void revalidateTable(String buscar) {
		alumnos = daoAlumno.getAlumnos(buscar);
		this.tablaAlumnos.setoAlumnos(alumnos);
		this.tablaAlumnos.revalidate();
		this.tablaAlumnos.repaint();
		System.out.println("Alumnos revalidados");
	}

	public Integer getSelectedStudent() {
		return selectedStudent;
	}

	public void setSelectedStudent(Integer selectedStudent) {
		this.selectedStudent = selectedStudent;
	}

	public static void main(String[] args) {
		new MainFrame();
	}
}
