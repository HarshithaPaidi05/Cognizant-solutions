import React, { useState } from 'react';
import CurrencyConvertor from './CurrencyConvertor';

function App() {
  const [count, setCount] = useState(0);

  // --- Increment related functions ---
  const increment = () => {
    setCount(prev => prev + 1);
    sayHello();
  };

  const sayHello = () => {
    console.log("Hello!");
    console.log("Increment button clicked and greeted.");
  };

  const decrement = () => {
    setCount(prev => prev - 1);
  };

  // --- Function with argument ---
  const sayMessage = (message) => {
    alert(`Message: ${message}`);
  };

  // --- Synthetic Event Handler ---
  const handleClick = (e) => {
    alert("I was clicked");
    console.log("Synthetic event triggered:", e);
  };

  return (
    <div style={{ padding: "20px" }}>
      <h1>React Event Examples</h1>

      <h2>Counter: {count}</h2>
      <button onClick={increment}>Increment</button>{" "}
      <button onClick={decrement}>Decrement</button>

      <hr />

      <button onClick={() => sayMessage("Welcome")}>Say Welcome</button>

      <hr />

      <button onClick={handleClick}>Click Me (Synthetic Event)</button>

      <hr />

      <CurrencyConvertor />
    </div>
  );
}

export default App;
