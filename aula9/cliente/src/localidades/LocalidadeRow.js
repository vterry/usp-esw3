import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';

const DataRow = styled.tr`
  &:hover {
    background: rgba(0, 0, 0, 0);
    color: darkgrey;
    cursor: pointer;
    box-shadow: inset 0 0 0 2px darkgrey;
  }
  &:nth-child(even) {
    background: lightgray;
  }
`;

const DataCell = styled.td`
  padding-top: 30px;
  padding-bottom: 30px;
`;

const DescricaoCell = styled(DataCell)`
  padding-left: 30px;
`;

const EstadoCell = styled(DataCell)`
  padding-left: 30px;
`;

function LocalidadeRow(props) {
  const { localidade } = props;

  return (
    <DataRow>
      <DescricaoCell>{localidade.descricao}</DescricaoCell>
      <EstadoCell>{localidade.estado}</EstadoCell>
    </DataRow>
  );
}

export default LocalidadeRow;
