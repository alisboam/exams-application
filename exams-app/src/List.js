import React from 'react'
import ListItem from './ListItem';

const List = ({examData}) => {
  return (
    <ul>
      {examData.map((item) => (
        <ListItem key={item.id} item={item} />
      ))}
    </ul>
  );
}

export default List
