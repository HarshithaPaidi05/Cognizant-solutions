import React from 'react';
import './App.css';

function App() {
  const heading = <h1>Office Space Rental Portal</h1>;

  const singleOffice = {
    name: "GreenHub Workspace",
    rent: 55000,
    address: "123 Business Street, Hyderabad"
  };

  const officeSpaces = [
    {
      name: "GreenHub Workspace",
      rent: 55000,
      address: "123 Business Street, Hyderabad",
      image: "https://via.placeholder.com/200x120?text=Office+1"
    },
    {
      name: "SkyTower Office",
      rent: 62000,
      address: "456 Skyline Road, Bangalore",
      image: "https://via.placeholder.com/200x120?text=Office+2"
    },
    {
      name: "EliteWork Centre",
      rent: 48000,
      address: "789 Elite Lane, Pune",
      image: "https://via.placeholder.com/200x120?text=Office+3"
    }
  ];

  return (
    <div className="App">
      {heading}

      <h2>Single Office Details</h2>
      <div>
        <p><strong>Name:</strong> {singleOffice.name}</p>
        <p>
          <strong>Rent:</strong>{" "}
          <span
            style={{ color: singleOffice.rent < 60000 ? 'red' : 'green' }}
          >
            ₹{singleOffice.rent}
          </span>
        </p>
        <p><strong>Address:</strong> {singleOffice.address}</p>
      </div>

      <h2>Available Office Spaces</h2>
      <div style={{ display: 'flex', gap: '20px' }}>
        {officeSpaces.map((office, index) => (
          <div key={index} style={{ border: '1px solid #ccc', padding: '10px', width: '220px' }}>
            <img src={office.image} alt={office.name} style={{ width: '100%' }} />
            <h3>{office.name}</h3>
            <p>
              <strong>Rent:</strong>{" "}
              <span
                style={{ color: office.rent < 60000 ? 'red' : 'green' }}
              >
                ₹{office.rent}
              </span>
            </p>
            <p><strong>Address:</strong> {office.address}</p>
          </div>
        ))}
      </div>
    </div>
  );
}

export default App;
