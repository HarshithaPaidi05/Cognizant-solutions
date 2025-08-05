import React, { useState } from 'react';

function CurrencyConvertor() {
  const [rupees, setRupees] = useState('');
  const [euro, setEuro] = useState(null);

  const conversionRate = 0.011; // 1 INR = 0.011 Euro (approx)

  const handleSubmit = (e) => {
    e.preventDefault();
    const result = parseFloat(rupees) * conversionRate;
    setEuro(result.toFixed(2));
  };

  return (
    <div>
      <h2>Currency Convertor (INR ➡️ Euro)</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="number"
          value={rupees}
          onChange={(e) => setRupees(e.target.value)}
          placeholder="Enter amount in INR"
        />
        <button type="submit">Convert</button>
      </form>
      {euro && (
        <p>
          ₹{rupees} = €{euro}
        </p>
      )}
    </div>
  );
}

export default CurrencyConvertor;
