const video = document.querySelector('.background-video');
video.playbackRate = 0.75;
$("#cpf").mask("000.000.000-00");
$("#cep").mask("00000-000");
$("#telefone").mask("(00)00000-0000");

window.onload = function() {
    isSelected();
};

const buttons = document.querySelectorAll('#step-1 button');

buttons.forEach(button => {
    button.addEventListener('click', () => {
        buttons.forEach(btn => btn.classList.remove('selected'));

        button.classList.add('selected');
        isSelected();
    });
});

function isSelected() {
    const selectedButton = document.querySelector('#step-1 button.selected');
    const nextButton = document.querySelector("#next_button");
    if (!selectedButton) {
        nextButton.disabled = true;
    } else {
        nextButton.disabled = false;
    }
}


