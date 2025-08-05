import React from 'react';
import FlightList from './FlightList';

export default function UserPage() {
  return (
    <section style={{ padding: 20 }}>
      <h2>User Dashboard</h2>
      <p>Welcome back! You can book flights from the list below.</p>
      <FlightList allowBooking={true} />
    </section>
  );
}
