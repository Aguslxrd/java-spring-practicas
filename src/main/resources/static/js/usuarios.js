$(document).ready(function() {
    cargarUsuarios();
    $('#usuarios').DataTable();
});

async function cargarUsuarios() {
    const request = await fetch('http://localhost:8080/usuarios', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    const usuarios = await request.json();

    let listadoHtml = '';
    for (const usuario of usuarios) {
        let usuarioHtml = '<tr><td>123</td><td>' + usuario.nombre + ' ' + usuario.apellido + '</td><td>' + usuario.email + '</td><td>' + usuario.telefono + '</td><td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>';
        listadoHtml += usuarioHtml;
    }

    document.querySelector('#usuarios tbody').innerHTML = listadoHtml;
    console.log(usuarios);
}