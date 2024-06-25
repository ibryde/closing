function convertJsonToPPT() {
    const formData = new FormData();
    const fileField = document.querySelector('input[type="file"]');

    if (fileField.files.length === 0) {
        alert("Please select a file.");
        return;
    }

    formData.append('jsonFile', fileField.files[0]);

    fetch('/convert', {
        method: 'POST',
        body: formData,
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            window.location.href = data.file_url;
        } else {
            alert('Conversion failed: ' + data.error);
        }
    })
    .catch(error => console.error('Error:', error));
}
