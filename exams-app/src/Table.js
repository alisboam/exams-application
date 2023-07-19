import React from 'react';
import Row from './Row';


const Table = ({ examData }) => {
  // console.log(`Exames: [${examData}]`)

  if (examData.length === 0) {
    return <div>Vazio</div>;
  }
  const columnValue = Object.keys(examData[0]).map((item) => {
    return <th>{item}</th>;
  });


  return (
    <div>
      KU
      <table>
        <thead>
          <tr>{columnValue}</tr>
        </thead>

        <tbody>
          {examData.map((item) => (
            <Row key={item.id} item={item}></Row>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Table;
