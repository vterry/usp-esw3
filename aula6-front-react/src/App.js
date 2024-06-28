import { useState } from 'react';
import Button from './Button.js';
import Pacotes from './Pacotes.js';


function App() {
  const [dados, setData] = useState([]);

  return (
    <>
      <Pacotes dados={dados}/>
      <Button setData={setData}/>
    </>
  );
}

export default App;