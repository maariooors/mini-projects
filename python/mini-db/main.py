from tkinter import *
from tkinter import messagebox
import sqlite3


# ---------------------funciones---------------------------

def conexionBBDD():
    miConexion = sqlite3.connect('Usuarios')
    miCursor = miConexion.cursor()

    try:

        miCursor.execute('''
    		CREATE TABLE DATOSUSUARIOS ( 
    		ID INTEGER PRIMARY KEY AUTOINCREMENT,
    		NOMBRE_USUARIO VARCHAR(50), 
    		PASSWORD VARCHAR(50),
    		APELLIDO VARCHAR(50),
    		DIRECCION VARCHAR(50),
    		COMENTARIOS VARCHAR(100))
    		''')
        messagebox.showinfo('BBDD', 'BBDD creada con exito')
    except:
        messagebox.showwarning('¡Ateción!', 'La BBDD ya existe')


def salirAplicacion():
    valor = messagebox.askquestion('Salir', 'Deseas salir de la aplicación')

    if valor == 'yes':
        root.destroy()


def limpiarCampos():
    cuadroID.set('')
    cuadro_nombre.set('')
    cuadroApellido.set('')
    cuadroDireccion.set('')
    cuadroPassword.set('')
    textoComentario.delete(1.0, END)  # borra desde el principio hasta el final porque no es un Label es un text


def crear():
    miConexion = sqlite3.connect('Usuarios')

    miCursor = miConexion.cursor()

    miCursor.execute(
        'INSERT INTO DATOSUSUARIOS(''cuadroID.get, cuadro_nombre.get, cuadroApellido.get, cuadroPassword.get, cuadroDireccion.get,textoComentario.get'')) VALUES(?, ?, ?, ?, ?, ?')

    miConexion.commit()

    messagebox.showinfo('BBDD', 'Registro insertado con éxito')


def leer():
#     miConexion = sqlite3.connect('Usuarios')
#
#     miCursor = miConexion.cursor()
#
#     miCursor.execute('SELECT * FROM DATOSUSUARIOS WHERE ID=

    elUsuario = miCursor.fetchall()

    for usuario in elUsuario:
        miId.set(usuario[0])
        miNombre.set(usuario[1])
        miPass.set(usuario[2])
        miApellido.set(usuario[3])
        miDireccion.set(usuario[4])
        textoComentario.insert(1.0, usuario[5])

    miConexion.commit()


root = Tk()

barra_menu = Menu(root)

root.config(menu=barra_menu, width=300, height=300)

bbdd_menu = Menu(barra_menu, tearoff=0)
bbdd_menu.add_command(label='Conectar', command=conexionBBDD)  # el label es el texto que va a aparecer
bbdd_menu.add_command(label='Salir', command=salirAplicacion)

borrar_menu = Menu(barra_menu, tearoff=0)
borrar_menu.add_command(label='Borrar Campos', command=limpiarCampos)

crud_menu = Menu(barra_menu, tearoff=0)
crud_menu.add_command(label='Crear', command=crear)
crud_menu.add_command(label='Leer', command=leer)
crud_menu.add_command(label='Actualizar')
crud_menu.add_command(label='Borrar')

ayuda_menu = Menu(barra_menu, tearoff=0)
ayuda_menu.add_command(label='Licencia')
ayuda_menu.add_command(label='Acerca de...')

# ---------------------MENU CONFIGURADO---------------------

barra_menu.add_cascade(label='BBDD', menu=bbdd_menu)
barra_menu.add_cascade(label='BORRAR', menu=borrar_menu)
barra_menu.add_cascade(label='CRUD', menu=crud_menu)
barra_menu.add_cascade(label='AYUDA', menu=ayuda_menu)

# ----------------------------COMIENZO DE CAMPOS----------------------------

mi_frame = Frame(root)
mi_frame.pack()

cuadroID = Entry(mi_frame)  # , textvariable=miID)
cuadroID.grid(row=0, column=1, padx=10, pady=10)

cuadro_nombre = Entry(mi_frame)  # , textvariable=miNombre)
cuadro_nombre.grid(row=1, column=1, padx=10, pady=10)

cuadroPassword = Entry(mi_frame)  # , textvariable=miPass)
cuadroPassword.grid(row=2, column=1, padx=10, pady=10)
cuadroPassword.config(show='*')  # show para que las letras se sustituyas por eso que he puesto

cuadroApellido = Entry(mi_frame)  # , textvariable=miApellido)
cuadroApellido.grid(row=3, column=1, padx=10, pady=10)

cuadroDireccion = Entry(mi_frame)  # , textvariable=miDireccion)
cuadroDireccion.grid(row=4, column=1, padx=10, pady=10)

textoComentario = Text(mi_frame, width=16, height=5)
textoComentario.grid(row=5, column=1, padx=10, pady=10)
scrollvert = Scrollbar(mi_frame, command=textoComentario.yview)
scrollvert.grid(row=5, column=2, sticky='nswe')  # NSEW ES NORTE SUR ESTE Y OESTE

textoComentario.config(yscrollcommand=scrollvert.set)


pruebaID = cuadroID.get()
pruebaNOM = cuadro_nombre.get()
pruebaAppe = cuadroApellido.get()
pruebaPass = cuadroPassword.get()
pruebaDIC = cuadroDireccion.get()
pruebaTexto = textoComentario.get(1.0, END)
# -----------------Aqui comienzan los label------------------

idLabel = Label(mi_frame, text='Id:')
idLabel.grid(row=0, column=0, sticky='e', padx=10, pady=10)

nombreLabel = Label(mi_frame, text='Nombre:')
nombreLabel.grid(row=1, column=0, sticky='e', padx=10, pady=10)

passLabel = Label(mi_frame, text='Password:')
passLabel.grid(row=2, column=0, sticky='e', padx=10, pady=10)

apellidoLabel = Label(mi_frame, text='Apellido:')
apellidoLabel.grid(row=3, column=0, sticky='e', padx=10, pady=10)

direccionLabel = Label(mi_frame, text='Direccion:')
direccionLabel.grid(row=4, column=0, sticky='e', padx=10, pady=10)

comentarioLabel = Label(mi_frame, text='Comentario:')
comentarioLabel.grid(row=5, column=0, sticky='e', padx=10, pady=10)

# -----------aqui los botones--------------

mi_frame2 = Frame(root)
mi_frame2.pack()

botonCrear = Button(mi_frame2, text='Create', command=crear)
botonCrear.grid(row=1, column=0, sticky='e', padx=10, pady=10)

botonLeer = Button(mi_frame2, text='Read', command=leer)
botonLeer.grid(row=1, column=1, sticky='e', padx=10, pady=10)

botonActualizar = Button(mi_frame2, text='Update')
botonActualizar.grid(row=1, column=2, sticky='e', padx=10, pady=10)

botonBorrar = Button(mi_frame2, text='Delete', command=limpiarCampos)
botonBorrar.grid(row=1, column=3, sticky='e', padx=10, pady=10)

root.mainloop()
