from tkinter import *
from tkinter import messagebox
import sqlite3

root = Tk()
root.title = ('MyGram')
root.resizable(False, False)  # EL metodo resizable significa que no deja que se maximize la pantalla o que se encoja
root.config(width=300, height=400)

miFrame = Frame(root)

try:

    conexion = sqlite3.connect('INICIO SESION')
    cursor = conexion.cursor()
    cursor.execute("CREATE TABLE INFORMACION_INICIO(NOMBRE_USUARIO VARCHAR(50), USUARIO_CONTRASEÑA VARCHAR(50))")
    cursor.execute("CREATE TABLE INFORMACION_REGISTRO(NOMBRE_USUARIO VARCHAR(50), APELLIDO_USUARIO VARCHAR(50), DIRECCION_USUARIO VARCHAR(50), TELEFONO_USUARIO INTVAR(9), EDAD_USUARIO INTVAR(2))")
    conexion.close()
except:
    sqlite3.OperationalError


def registrarSesion():
    def enviar():
        if entryNombre.get() == '' or entryApellido == '' or entryDireccion == '' or entryTelefono == '' or entryEdad == '':
            mensaje = messagebox.showwarning('EMPTY', 'LA INFORMACION NO ES CORRECTA')
            frameRegistro.destroy()

        else:
            pass

        # '''if entryTelefono.get() == Int or entryEdad.get() == Int:
        #     mensajeNum = messagebox.showwarning('BBDD', 'LA INFORMACION INTRODUCIDA N0 ES CORRECTA')
        #
        # else:
        #     pass'''

        conexionRe = sqlite3.connect('INICIO SESION')
        cursorRe = conexionRe.cursor()
        cursorRe.execute("INSERT INTO INFORMACION_REGISTRO VALUES('" + entryNombre.get() +
                         "','" + entryApellido.get() +
                         "','" + entryDireccion.get() +
                         "','" + entryTelefono.get() +
                         "','" + entryEdad.get() + "')")
        conexionRe.commit()



    frameRegistro = Frame(miFrame)
    frameRegistro.config(width=300, height=400, bg='#44bcd8')
    frameRegistro.grid()

    # -----------Label----------------
    labelNombre = Label(frameRegistro, text='Nombre : ', width=10, height=1, bg='#44bcd8')
    labelNombre.place(relx=0.1, rely=0.2, anchor='nw')

    labelApellido = Label(frameRegistro, text='Apellido : ', width=10, height=1, bg='#44bcd8')
    labelApellido.place(relx=0.1, rely=0.3, anchor='nw')

    labelDireccion = Label(frameRegistro, text='Dirección : ', width=10, height=1, bg='#44bcd8')
    labelDireccion.place(relx=0.1, rely=0.4, anchor='nw')

    labelTelefono = Label(frameRegistro, text='Telefono : ', width=10, height=1, bg='#44bcd8')
    labelTelefono.place(relx=0.1, rely=0.5, anchor='nw')

    labelEdad = Label(frameRegistro, text='Edad : ', width=10, height=1, bg='#44bcd8')
    labelEdad.place(relx=0.1, rely=0.6, anchor='nw')

    # ---------Entry----------------

    entryNombre = Entry(frameRegistro)
    entryNombre.place(relx=0.55, rely=0.2255, anchor=CENTER)

    entryApellido = Entry(frameRegistro)
    entryApellido.place(relx=0.55, rely=0.326, anchor=CENTER)

    entryDireccion = Entry(frameRegistro)
    entryDireccion.place(relx=0.55, rely=0.425, anchor=CENTER)

    entryTelefono = Entry(frameRegistro)
    entryTelefono.place(relx=0.55, rely=0.525, anchor=CENTER)

    entryEdad = Entry(frameRegistro)
    entryEdad.place(relx=0.55, rely=0.6255, anchor=CENTER)

    # ---------Boton----------------

    botonEviarRegistro = Button(frameRegistro, width=10, height=1, text='Enviar', relief='flat', command = enviar)
    botonEviarRegistro.place(relx=0.5, rely=0.75, anchor=CENTER)


def iniciarSesion():
    def aceptar():

        if entryUsu.get() == '' and entryPass.get() == '':
            mensajeVacio = messagebox.showwarning('EMPTY', 'POR FAVOR RELLENE LA INFORMACIÓN')
            frameInicio.destroy()
        else:
            pass

        conexion = sqlite3.connect("INICIO SESION")

        cursor = conexion.cursor()

        cursor.execute("INSERT INTO INFORMACION_INICIO VALUES('" + entryUsu.get() +
                       "','" + entryPass.get() + "')")

        conexion.commit()

        mensajeConfirmacion = messagebox.showwarning('BBDD', 'SU INFORMACIÓN A SIDO REGISTRADA CON EXITO')
        frameInicio.destroy()

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
    botonAceptar.place(relx=0.5, rely=0.6, anchor=CENTER)

    # -------------Entry-------------------

    entryUsu = Entry(frameInicio)  # , textvariable = usuID)
    entryUsu.place(relx=0.55, rely=0.2255, anchor=CENTER)

    entryPass = Entry(frameInicio, show='#')  # , textvariable = passID)
    entryPass.place(relx=0.555, rely=0.3255, anchor=CENTER)

    # ------------CheckButton----------------------

    botonCheck = Checkbutton(frameInicio, relief='flat')
    botonCheck.place(relx=0.2, rely=0.425, anchor=CENTER)

    labelConfi = Label(frameInicio, text='Yo no soy un hipopotamo', bg='#90EE90')
    labelConfi.place(relx=0.55, rely=0.425, anchor=CENTER)


# ---------Configuracion de la root---------------------------



# ---------Configuracion del frame-----------------

miFrame.config(width=300, height=400, bg='#44bcd8')
miFrame.grid()

#-------------Configuración del menu-------------

# miMenu=Menu(root)
# root.config(menu=miMenu)

# -------------Botones del frame---------------

buttonInico = Button(miFrame, width=10, height=1, text='Iniciar sesión', fg='black', relief='flat', bg='#00d5b8',
                     command=iniciarSesion)
buttonInico.place(relx=0.5, rely=0.525, anchor=CENTER)

buttonRegistrarse = Button(miFrame, width=10, height=1, text='Registrarse', fg='black', relief='flat', bg='#00d5b8',
                           command=registrarSesion)
buttonRegistrarse.place(relx=0.5, rely=0.6, anchor=CENTER)

root.mainloop()

