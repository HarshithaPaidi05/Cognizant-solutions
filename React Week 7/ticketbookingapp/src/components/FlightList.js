import React, { useState } from 'react';
import './FlightList.css';

/*
  FlightList receives:
    - allowBooking (boolean) : if true, show active Book button
*/

const initialFlights = [
  { id: 1, airline: 'Air India', from: 'Hyderabad', to: 'Mumbai', time: '08:30', price: 3500, seats: 5 },
  { id: 2, airline: 'IndiGo', from: 'Bangalore', to: 'Delhi', time: '10:00', price: 4200, seats: 3 },
  { id: 3, airline: 'SpiceJet', from: 'Chennai', to: 'Kolkata', time: '13:20', price: 3900, seats: 8 },
  { id: 4, airline: 'Vistara', from: 'Pune', to: 'Goa', time: '17:45', price: 2900, seats: 0 }, // sold out example
];

export default function FlightList({ allowBooking }) {
  const [flights, setFlights] = useState(initialFlights);

  const handleBook = (flightId) => {
    setFlights(prev =>
      prev.map(f => {
        if (f.id === flightId) {
          if (f.seats <= 0) {
            alert('Sorry, no seats available for this flight.');
            return f;
          }
          // simulate booking: decrement seats
          const updated = { ...f, seats: f.seats - 1 };
          alert(`Booking confirmed on ${f.airline} from ${f.from} to ${f.to} at ${f.time}.`);
          return updated;
        }
        return f;
      })
    );
  };

  return (
    <div className="flight-list">
      {flights.map(flight => (
        <div key={flight.id} className="flight-card">
          <div className="flight-header">
            <strong>{flight.airline}</strong> <span className="route">{flight.from} → {flight.to}</span>
          </div>
          <div className="flight-body">
            <div>Departure: {flight.time}</div>
            <div>Price: ₹{flight.price}</div>
            <div>Seats available: {flight.seats}</div>
          </div>
          <div className="flight-actions">
            {allowBooking ? (
              <button
                className="btn btn-book"
                onClick={() => handleBook(flight.id)}
                disabled={flight.seats <= 0}
              >
                {flight.seats <= 0 ? 'Sold Out' : 'Book Ticket'}
              </button>
            ) : (
              <button className="btn btn-login-to-book" disabled>
                Login to Book
              </button>
            )}
          </div>
        </div>
      ))}
    </div>
  );
}
