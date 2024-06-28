
import styled from 'styled-components';
import { loadPacotes } from './stub.js';

const InnerButton = styled.button`
`;

function Button(props) {
  const { setData } = props;
  const onClick = async () => {
    const data = await loadPacotes();
    setData(data)
  }

  return (
      <InnerButton onClick={onClick}>Carregar</InnerButton>
  );
}

export default Button;