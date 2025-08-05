import React from 'react';
import FlightList from './FlightList';

export default function GuestPage() {
  return (
    <section style={{ padding: 20 }}>
      <h2>Welcome Guest</h2>
      <p>Please <strong>login</strong> to book tickets. You can browse available flights below.</p>
      <FlightList allowBooking={false} />
    </section>
  );
}
