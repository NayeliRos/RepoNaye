
function generarUsuario() {
  var uuid = java.util.UUID.randomUUID() + '';
  return {
    nome: 'Usuario ' + uuid.substring(0, 8),
    email: 'user' + uuid.substring(0, 8) + '@mail.com',
    password: '123456',
    administrador: 'true'
  };
}
function fn() {
  return { generarUsuario: generarUsuario };
}
