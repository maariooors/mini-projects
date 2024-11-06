from tkinter import *
from tkinter import messagebox
import sqlite3

mi_lista = []
#-------CREO LA ROOT--------------

root = Tk()
root.title('MyGram')

miFrame = Frame(root)
miFrame.config(width=300, height=400, bg='#44bcd8')
miFrame.grid()

#------------CONEXION A BASE DE DATOS---------------

try:

    conexion = sqlite3.connect('INICIO SESION')
    cursor = conexion.cursor()
    cursor.execute("CREATE TABLE INFORMACION_INICIO(NOMBRE_USUARIO VARCHAR(50), USUARIO_CONTRASEÑA VARCHAR(50))")
    cursor.execute("CREATE TABLE INFORMACION_REGISTRO(NOMBRE_USUARIO VARCHAR(50), APELLIDO_USUARIO VARCHAR(50), CONTRASEÑA_USUARIO VARCHAR(50), TELEFONO_USUARIO INTVAR(9), EDAD_USUARIO INTVAR(2))")
    conexion.close()
except:
    sqlite3.OperationalError


#--------CREO LAS DEFINICONES-------------
def salirApp():  
    mensajeSaliApp = messagebox.askquestion('APP','¿QUIERES SALIR DE LA APLICACIÓN?')

    if mensajeSaliApp == 'yes':
        root.destroy()

    else:
        pass



def iniciarSesion():

    def mostrarContraseñaUsu():

        intCheck1 = IntVar()
        

        if intCheck1.get() == 1:
   
            contraAlmacenada = entryPass.get()
            entryPass.delete(0, len(entryPass.get()))
            entryPass.insert(contraAlmacenada)
        if intCheck1 == 0:

            entryPass.insert(contraAlmacenada.show('#'))

    

    def borrarUsu():

        entryUsu.delete(0, len(entryUsu.get()))
        entryPass.delete(0, len(entryPass.get()))

    def atrasUsu():
        frameInicio.destroy()

    def aceptar():

        if entryUsu.get() == '' and entryPass.get() == '':
            mensajeVacio = messagebox.showwarning('EMPTY', 'POR FAVOR RELLENE LA INFORMACIÓN')
        else:
            pass

        if mi_lista[0:1] == entryUsu.get() and mi_lista[1:2] == entryPass.get():

            mensaje_inicio = messagebox.showinfo('APP', 'SU INICIO DE SESION HA SIDO CORRECTO')

        else:
            mensaje_inicio_malo = messagebox.showwarning('APP', 'NO SE HA PODIDO ENCONTRAR EL USUARIO Y LA CONSTRASEÑA')
        # else:

        #     conexion = sqlite3.connect("INICIO SESION")

        #     cursor = conexion.cursor()

        #     infoNombre = cursor.execute("SELECT NOMBRE_USUARIO FROM INFORMACION_INICIO")
        #     infoApellido = cursor.execute("SELECT USUARIO_CONTRASEÑA FROM INFORMACION_INICIO")

            

        #     if entryUsu.get() != infoNombre or entryPass.get() != infoApellido:
        #         mensajeTriste = messagebox.showwarning('BBDD', 'NO SE HA ENCONTRADO SU USUARIO')
            

            #else:
            #     mesajeAlegria = messagebox.showinfo('BBDD', 'SU USUARIO HA SIDO ENCONTRADO CON EXITO')
            #     conexion.commit()
            #     frameInicio.destroy()

            
            

    frameInicio = Frame(miFrame)
    frameInicio.config(width=300, height=400, bg='#90EE90')
    frameInicio.grid()

    # -----------------Label-------------------

    labelUsu = Label(frameInicio, text='Usuario : ', width=10, height=1, bg='#90EE90')
    labelUsu.place(relx=0.1, rely=0.2, anchor='nw')

    labelPass = Label(frameInicio, text='Contraseña : ', width=10, height=1, bg='#90EE90')
    labelPass.place(relx=0.1, rely=0.3, anchor='nw')

    # -------------Botones----------------

    botonAceptar = Button(frameInicio, width=10, height=1, text='Aceptar', relief='flat', command=aceptar)
    botonAceptar.place(relx=0.4, rely=0.6, anchor=CENTER)

    botonAtrasUsu = Button(frameInicio, width=10, height=1, text = 'Atras', relief='flat', command = atrasUsu)
    botonAtrasUsu.place(relx = 0.7, rely = 0.6, anchor = CENTER)

    botonBorrarUsu = Button(frameInicio, width=10, height=1, text = 'Borrar', relief = 'flat', command = borrarUsu)
    botonBorrarUsu.place(relx = 0.55, rely = 0.7, anchor = CENTER)

    botonLeerUsu = Checkbutton(frameInicio,height = 1, text = 'MOSTRAR CONTASEÑA', relief = 'flat', bg = '#90EE90', variable = mostrarContraseñaUsu)
    botonLeerUsu.place(relx = 0.3, rely = 0.375)

    # -------------Entry-------------------

    entryUsu = Entry(frameInicio)  # , textvariable = usuID)
    entryUsu.place(relx=0.55, rely=0.2255, anchor=CENTER)

    entryPass = Entry(frameInicio, show='#')  # , textvariable = passID)
    entryPass.place(relx=0.555, rely=0.3255, anchor=CENTER)

  
def registrarSesion():

    def borrar():

        entryNombre.delete(0, len(entryNombre.get()))
        entryApellido.delete(0, len(entryApellido.get()))
        entryContraseña.delete(0, len(entryContraseña.get()))
        entryTelefono.delete(0, len(entryTelefono.get()))
        entryEdad.delete(0, len(entryEdad.get()))


    def atrasRegi():
        frameRegistro.destroy()
    
    def enviar():
        if entryNombre.get() == '' and entryApellido == '' and entryContraseña == '' and entryTelefono == '' and entryEdad == '':
            mensaje = messagebox.showwarning('EMPTY', 'LA INFORMACION NO ES CORRECTA')
            

        else:   

            conexionRe = sqlite3.connect('INICIO SESION')
            cursorRe = conexionRe.cursor()
            cursorRe.execute("INSERT INTO INFORMACION_REGISTRO VALUES('" + entryNombre.get() +
                         "','" + entryApellido.get() +
                         "','" + entryContraseña.get() +
                         "','" + entryTelefono.get() +
                         "','" + entryEdad.get() + "')")
            cursorRe.execute("INSERT INTO INFORMACION_INICIO VALUES('" + entryNombre.get() + 
                         "','" + entryContraseña.get() + "')")
            conexionRe.commit()

            mesajeExito = messagebox.showwarning('BBDD','LA INFORMACION HA SIDO INGRESADA CON EXITO')
            mi_lista.append[entryNombre.get(), entryContraseña.get()]
            frameRegistro.destroy()


    frameRegistro = Frame(miFrame)
    frameRegistro.config(width=300, height=400, bg='#44bcd8')
    frameRegistro.grid()

    # -----------Label----------------
    labelNombre = Label(frameRegistro, text='Nombre : ', width=10, height=1, bg='#44bcd8')
    labelNombre.place(relx=0.1, rely=0.2, anchor='nw')

    labelApellido = Label(frameRegistro, text='Apellido : ', width=10, height=1, bg='#44bcd8')
    labelApellido.place(relx=0.1, rely=0.3, anchor='nw')

    labelContraseña = Label(frameRegistro, text='Contraseña : ', width=10, height=1, bg='#44bcd8')
    labelContraseña.place(relx=0.1, rely=0.4, anchor='nw')

    labelTelefono = Label(frameRegistro, text='Telefono : ', width=10, height=1, bg='#44bcd8')
    labelTelefono.place(relx=0.1, rely=0.5, anchor='nw')

    labelEdad = Label(frameRegistro, text='Edad : ', width=10, height=1, bg='#44bcd8')
    labelEdad.place(relx=0.1, rely=0.6, anchor='nw')

    # ---------Entry----------------

    entryNombre = Entry(frameRegistro)
    entryNombre.place(relx=0.55, rely=0.2255, anchor=CENTER)

    entryApellido = Entry(frameRegistro)
    entryApellido.place(relx=0.55, rely=0.326, anchor=CENTER)

    entryContraseña = Entry(frameRegistro, show = '#')
    entryContraseña.place(relx=0.55, rely=0.425, anchor=CENTER)
    entryTelefono = Entry(frameRegistro)
    entryTelefono.place(relx=0.55, rely=0.525, anchor=CENTER)

    entryEdad = Entry(frameRegistro)
    entryEdad.place(relx=0.55, rely=0.6255, anchor=CENTER)

    # ---------Boton----------------

    botonEviarRegistro = Button(frameRegistro, width=10, height=1, text='Enviar', relief='flat', command = enviar)
    botonEviarRegistro.place(relx=0.4, rely=0.75, anchor=CENTER)

    botonAtras = Button(frameRegistro, width=10, height=1, text = 'Atras', relief = 'flat', command = atrasRegi)
    botonAtras.place(relx=0.7, rely= 0.75, anchor = CENTER)

    botonBorrar = Button(frameRegistro, width = 10, height = 1, text = 'Borrar', relief = 'flat',command = borrar)
    botonBorrar.place(relx = 0.55, rely = 0.85, anchor = CENTER)


def ayuda():

    mensajeAyuda = messagebox.showinfo('HELP', 'LA VERSION DE MyGram ES LA 1.23')

def acercaDe():

    mesajeAcerca = messagebox.showinfo('MyGram', 'EL CREADOR DE ESTA APP ES MARIO RAMOS')






#--------Configuro la root----------


root.resizable(False, False) 
root.config(width=300, height=400)

miMenu = Menu(root)
root.config(menu=miMenu)

cerrarMenu = Menu(miMenu, tearoff=0)
cerrarMenu.add_command(label="Salir", command = salirApp)

helpmenu = Menu(miMenu, tearoff=0)
helpmenu.add_command(label="Ayuda", command = ayuda)
helpmenu.add_separator()
helpmenu.add_command(label="Acerca de...", command = acercaDe)

miMenu.add_cascade(label="Cerrar", menu=cerrarMenu)
miMenu.add_cascade(label="Ayuda", menu=helpmenu)

#-----------CONFIGURO EL FRAME---------

buttonInico = Button(miFrame, width=10, height=1, text='Iniciar sesión', fg='black', relief='flat', bg='#00d5b8',
                     command=iniciarSesion)
buttonInico.place(relx=0.5, rely=0.525, anchor=CENTER)

buttonRegistrarse = Button(miFrame, width=10, height=1, text='Registrarse', fg='black', relief='flat', bg='#00d5b8',
                           command=registrarSesion)
buttonRegistrarse.place(relx=0.5, rely=0.6, anchor=CENTER)



root.mainloop()


 