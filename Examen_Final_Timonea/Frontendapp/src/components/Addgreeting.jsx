import React, { useState } from 'react';

const AddGreetingForm = () => {
  const [description, setDescription] = useState('');
  const [price, setPrice] = useState('');
  const [typeID, setTypeID] = useState('');
  const [categoryID, setCategoryID] = useState('');
  const [message, setMessage] = useState('');

  const handleSubmit = async (e) => {
      e.preventDefault();
    const greeting = { description, price: parseFloat(price), typeID, categoryID };

    try {
      const response = await fetch('http://localhost:8080/greeting/add', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(greeting),
      });

      if (response.ok) {
        const data = await response.text();
        setMessage(`success: ${data}`);

      } else {

        const errorData = await response.text();
        setMessage(`error: ${errorData}`);
      }


    } catch (error) {
      setMessage(`error: ${error.message}`);
    }

  };

  return (

    <div>
      <h2>Adauga o felicitare noua</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Descriere:</label>
          <input
            type="text"
            value={description}
            onChange={(e) => setDescription(e.target.value)}
            required
          />
        </div>

        <div>
          <label>Pret:</label>
          <input
          type="number"
            step="0.01"
            value={price}
            onChange={(e) => setPrice(e.target.value)}
            required
          />
        </div>

        <div>
          <label>Type ID:</label>
          <input
            type="number"
            value={typeID}
            onChange={(e) => setTypeID(e.target.value)}
            required
          />
        </div>

        <div>
          <label>Category ID:</label>
          <input
            type="number"
            value={categoryID}
            onChange={(e) => setCategoryID(e.target.value)}
            required
          />
        </div>

        <button type="submit">Submit</button>

      </form>
      {message && <p>{message}</p>}
    </div>
    
  );
};

export default AddGreetingForm;