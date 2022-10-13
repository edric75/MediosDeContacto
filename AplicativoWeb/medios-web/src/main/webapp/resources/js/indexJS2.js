


$('#rfcRadio').click(function () {
    $('#rfc').prop('disabled', false);
    $('#curp').prop('disabled', true);
    $('#email').prop('disabled', true);

    $('#curp').val("");
    $('#email').val("");

});
$('#curpRadio').click(function () {
    $('#curp').prop('disabled', false);
    $('#rfc').prop('disabled', true);
    $('#email').prop('disabled', true);
    $('#rfc').val("");
    $('#email').val("");

});
$('#emailRadio').click(function () {
    $('#curp').prop('disabled', true);
    $('#rfc').prop('disabled', true);
    $('#email').prop('disabled', false);
    $('#email').val("");
    $('#rfc').val("");
    $('#curp').val("");
});




