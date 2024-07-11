import styled from 'styled-components';
import debounce from 'lodash.debounce';

const InnerInput = styled.input`
`;

function Criteria(props) {
  const {setCriteria} = props;
  
  const doChangeCriteria = (e) => setCriteria(e.target.value);
  const onCriteriaChange = debounce(doChangeCriteria, 500);

  return (
      <InnerInput onChange={onCriteriaChange}></InnerInput>
  );
}

export default Criteria;