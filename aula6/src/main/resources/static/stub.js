function loadPacotes(callback) {
    const req = new XMLHttpRequest();
    req.addEventListener("load", (resp) => {
        console.log(`Carregado pacotes (payload : ${req.responseText})`);
        const data = JSON.parse(req.responseText);
        callback(data);
    });
    req.open("GET", "/pacotes");
    req.send();
}

export { loadPacotes };