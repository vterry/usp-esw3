async function loadLocalidades(criteria) {
  const response = await fetch(endpointFor(criteria));
  const data = await response.json();
  console.log(`Carregadas localidades (payload : ${data})`);
  return data;

}

async function loadLocalidade(id) {
const endpoint = `http://localhost:8080/localidades/${id}`
const response = await fetch(endpoint);
const data = await response.json();
console.log(`Carregado pacote (payload : ${data})`);
return data;

}


function endpointFor(criteria) {
const endpoint = "http://localhost:8080/localidades";

if (criteria) {
  return `${endpoint}?q=${criteria}`
} else {
  return endpoint;    
}
}

export { loadLocalidades, loadLocalidade };