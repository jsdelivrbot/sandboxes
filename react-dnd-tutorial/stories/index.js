import React from 'react';
import { storiesOf, action, linkTo } from '@kadira/storybook';
import Button from './Button';
import Welcome from './Welcome';
import Knight from './../src/Knight';
import Square from './../src/Square';

storiesOf('Welcome', module)
  .add('to Storybook', () => (
    <Welcome showApp={linkTo('Button')}/>
  ));

storiesOf('Button', module)
  .add('with text', () => (
    <Button onClick={action('clicked')}>Hello Button</Button>
  ))
  .add('with some emoji', () => (
    <Button onClick={action('clicked')}>😀 😎 👍 💯</Button>
  )
);

storiesOf('Chessboard', module).
  add('Basic Knight', () => (
    <Knight />
  ))
  .add('Black Square w/ Knight', () => (
    <Square black>
      <Knight />
    </Square>
  ))
  .add('White Square w/ Knight', () => (
    <Square>
      <Knight />
    </Square>
  )
);
