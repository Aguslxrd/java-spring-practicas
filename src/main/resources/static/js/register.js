async function registrarUsuarios() {
    let datos = {};
    datos.nombre = document.getElementById('txtNombre').value;
    datos.apellido = document.getElementById('txtApellido').value;
    datos.email = document.getElementById('txtEmail').value;
    datos.passwd = document.getElementById('txtPassword').value;

    let repetirPassword = document.getElementById('txtPasswordRepeat');

    if (repetirPassword.value != datos.passwd) {
        alert("La contraseña no coincide");
        return;
    }

    try {
        const request = await fetch('http://localhost:8080/api/v1/usuarios', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(datos)
        });

        if (!request.ok) {
            throw new Error('Error en la solicitud');
        }

        // Analizar la respuesta solo si es exitosa
        const usuarios = await request.json();
    } catch (error) {
        console.error('Error:', error);
    }
}
