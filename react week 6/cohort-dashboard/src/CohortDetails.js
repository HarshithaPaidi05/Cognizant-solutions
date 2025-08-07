import React from 'react';
import styles from './CohortDetails.module.css';

function CohortDetails() {
  const cohorts = [
    { id: 1, name: 'React Bootcamp', status: 'ongoing' },
    { id: 2, name: 'Java Basics', status: 'completed' },
    { id: 3, name: 'Spring Boot Pro', status: 'completed' },
    { id: 4, name: 'Frontend Mastery', status: 'ongoing' },
  ];

  return (
    <div>
      {cohorts.map(cohort => (
        <div key={cohort.id} className={styles.box}>
          <h3 style={{ color: cohort.status === 'ongoing' ? 'green' : 'blue' }}>
            {cohort.name}
          </h3>
          <dl>
            <dt>Status:</dt>
            <dd>{cohort.status}</dd>
          </dl>
        </div>
      ))}
    </div>
  );
}

export default CohortDetails;
