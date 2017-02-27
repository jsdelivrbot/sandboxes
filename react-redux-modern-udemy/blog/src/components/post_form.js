import React, { Component } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux'
import { Field, reduxForm } from 'redux-form';
import { createPost } from '../actions/index';

class PostForm extends Component {
  render() {
    //handleSubmit is a redux-form function that is available because we wrapped this React component in the reduxForm
    //function below.  This will be called when the user submits the form.
    //ES6 equivalent shorthand to "const handleSubmit = this.props.handleSubmit;"
    const { handleSubmit } = this.props;

    return (
      <form onSubmit={handleSubmit(this.props.createPost)}>
        <h3>Create A New Post</h3>

        <div className="form-group">
          <label htmlFor="title">Title</label>
          <Field name="title" component={this.renderField} type="text"/>
        </div>

        <div className="form-group">
          <label htmlFor="categories">Categories</label>
          <Field name="categories" component={this.renderField} type="text"/>
        </div>

        <div className="form-group">
          <label htmlFor="content">Content</label>
          <Field name="content" component={this.renderTextArea} type="text"/>
        </div>

        <button type="submit" className="btn btn-primary">Submit</button>
      </form>
    )
  }

  renderField(field) {
    return (<div className="input-row">
      <input {...field.input} placeholder={field.label} type={field.type}/>
      {field.meta.touched && field.meta.error &&
      <span className="error">{field.meta.error}</span>}
    </div>);
  }

  renderTextArea(field) {
    return (<div className="input-row">
      <textarea {...field.input} placeholder={field.label} type={field.type}/>
      {field.meta.touched && field.meta.error &&
      <span className="error">{field.meta.error}</span>}
    </div>);
  }
}



/**
 * This function is passed in to the reduxForm configuration and is called any time the form data is changed.
 */
function validate(values) {
  const errors = {};

  if (!values.title) {
    errors.title = 'Enter a title';
  }

  if (!values.categories) {
    errors.categories = 'Enter some categories';
  }

  if (!values.content) {
    errors.content = 'Enter some content';
  }

  return errors;
}

function mapDispatchToProps(dispatch) {
  return bindActionCreators({
    createPost: createPost
  }, dispatch);
}

// connect: first argument is mapStateToProps, 2nd is mapDispatchToProps
// reduxForm: first and only argument is a configuration object
export default connect(null, mapDispatchToProps)(reduxForm({
  //The form field values are stored in the global redux state like the following:
  // form: {
  //   post_form: {
  //     title: 'val',
  //     categories: 'val',
  //     content: 'val'
  //   }
  // }
  form: 'post_form',  //must be a unique name as it is stored as a prop with the same name in the global state
  validate
})(PostForm));