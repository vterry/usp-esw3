async function loadLocalidades(criteria) {
  const response = await fetch(endpointFor(criteria));
  const data = await response.json();
  console.log(`Carregadas localidades (payload : ${data})`);
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

export { loadLocalidades };