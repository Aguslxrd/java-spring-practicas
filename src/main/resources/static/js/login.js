async function iniciarSesion() {
    let datos = {};
    datos.email = document.getElementById('txtEmail').value;
    datos.passwd = document.getElementById('txtPassword').value;
    datos.token;

    try {
        const request = await fetch('http://localhost:8080/api/v1/login', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(datos)
        });
        const response = await request.json();
        if (response != 'Login failed' ) { //checkear estados http
            localStorage.token = response.token;
            localStorage.email = datos.email;
        }else{
            throw new Error('Error en la solicitud');
        }

        // Analizar la respuesta solo si es exitosa

    } catch (error) {
        console.error('Error:', error);
    }
}
