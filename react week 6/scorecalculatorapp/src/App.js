import React from 'react';
import './App.css';
import CalculateScore from './Components/CalculateScore';

function App() {
  return (
    <div className="App">
      <CalculateScore 
        name="Paidi Harshita" 
        school="Sunshine High School" 
        total={470} 
        goal={5} 
      />
    </div>
  );
}

export default App;
