import React from 'react';
import { useState, useEffect } from 'react';
import Table from './Table';
import StickyHeadTable from './StickyHeadTable';
import SearchAppBar from './SearchAppBar';

function App() {
  const apiUrl = 'http://localhost:8080/exams';
  const [examData, setExamData] = useState(0);

  useEffect(() => {
    const fetchApi = async () => {
      try {
        const response = await fetch(apiUrl);
        if (!response.ok) {
          throw new Error('Network response was not OK');
        }
        const exams = await response.json();
        setExamData(exams);
      } catch (error) {
        console.log(error);
      }
    };
    fetchApi();
  }, []);

  return (
    <div className='App'>
      {/* <Table examData={examData} /> */}
      <SearchAppBar />
      <StickyHeadTable examData={examData} />
    </div>
  );
}

export default App;
