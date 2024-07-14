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
  padding-top: 20px;
  padding-bottom: 20px;
`;

const DescricaoCell = styled(DataCell)`
  padding-left: 20px;
`;

const EstadoCell = styled(DataCell)`
  text-align: center;
`;

const ValorCell = styled(DataCell)`
  text-align: right;
  padding-right: 20px;
`;

function LocalidadeRow(props) {
  const { localidade } = props;
  const navigate = useNavigate();

  const selectLocalidade = () => {
    navigate(`/localidades/${localidade.id}`);
  };

  return (
    <DataRow onClick={selectLocalidade}>
      <DescricaoCell>{localidade.localidade.descricao}</DescricaoCell>
      <EstadoCell>{localidade.localidade.estado}</EstadoCell>
      <ValorCell>{localidade.valor}</ValorCell>
    </DataRow>
  );
}

export default LocalidadeRow;
