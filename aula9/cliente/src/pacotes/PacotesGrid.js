import PacoteRow from './PacoteRow.js';

import styled from 'styled-components';

const PacotesTable = styled.table`
  border-collapse: collapse;
`;

const HeaderRow = styled.tr`
  height: 46px;
  border-bottom: 1px solid;
`;

const HeaderCell = styled.th`
`;


const DescricaoCell = styled(HeaderCell)`
`

const LocalidadeCell = styled(HeaderCell)`
`

const ValorCell = styled(HeaderCell)`
  text-align: right;
  padding-right: 12px;
`


function PacotesGrid(props) {
  const { dados } = props;
  const rows = dados.map((x) => (<PacoteRow pacote={x}/>))

  return (
      <PacotesTable>
          <PacotesTableHeader/>
          {rows}
      </PacotesTable>
  );
}

function PacotesTableHeader() {
  return (
    <HeaderRow>
      <DescricaoCell>Descrição</DescricaoCell>
      <LocalidadeCell>Localidade</LocalidadeCell>
      <ValorCell>Preço</ValorCell>
    </HeaderRow>
  )
}

export default PacotesGrid;