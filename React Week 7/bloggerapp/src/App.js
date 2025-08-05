import React, { useState } from 'react';
import './App.css';
import BookDetails from './components/BookDetails';
import BlogDetails from './components/BlogDetails';
import CourseDetails from './components/CourseDetails';

function App() {
  const [view, setView] = useState('book'); // book, blog, course
  const [showCourse, setShowCourse] = useState(false);

  return (
    <div className="App">
      <h1>📖 Blogger App</h1>

      <div className="btn-container">
        <button onClick={() => setView('book')}>Show Book</button>
        <button onClick={() => setView('blog')}>Show Blog</button>
        <button onClick={() => setView('course')}>Show Course</button>
        <button onClick={() => setShowCourse(prev => !prev)}>
          Toggle Course (Boolean)
        </button>
      </div>

      <hr />

      <h2>1️⃣ If-Else Rendering</h2>
      {(() => {
        if (view === 'book') {
          return <BookDetails />;
        } else if (view === 'blog') {
          return <BlogDetails />;
        } else {
          return <CourseDetails />;
        }
      })()}

      <hr />

      <h2>2️⃣ Logical && Rendering</h2>
      {showCourse && <CourseDetails />}

      <hr />

      <h2>3️⃣ Ternary Rendering</h2>
      {view === 'book' ? <BookDetails /> : <BlogDetails />}

      <hr />

      <h2>4️⃣ Switch-Case Rendering</h2>
      {(() => {
        switch (view) {
          case 'book':
            return <BookDetails />;
          case 'blog':
            return <BlogDetails />;
          case 'course':
            return <CourseDetails />;
          default:
            return <p>Please select a view.</p>;
        }
      })()}
    </div>
  );
}

export default App;
