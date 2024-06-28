const endpoint = "http://localhost:8080/pacotes";

async function loadPacotes() {
    const response = await fetch(endpoint);
    const data = await response.json();
    console.log(`Carregado pacotes (payload : ${data})`);
    return data;
  
}
  
  export { loadPacotes };