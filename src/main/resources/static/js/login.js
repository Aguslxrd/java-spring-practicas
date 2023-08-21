async function iniciarSesion() {
    let datos = {};
    datos.email = document.getElementById('txtEmail').value;
    datos.passwd = document.getElementById('txtPassword').value;

    try {
        const request = await fetch('http://localhost:8080/api/v1/login', {
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
        const response = await request.json();
    } catch (error) {
        console.error('Error:', error);
    }
}
