import React from 'react';

// So far we've just been using function components.
// Now that we need to worry about state in our component, we need to use the ES6 class syntax.
// To turn an ES6 class into a React component, you extend React.Component
// (or `import {Component} from 'react'` and use that)
//
// Exercise:
//
// Our EditNote component needs to have two input fields for title and content. 
// Changes on this fields needs to be saved in the local component state and displayed on the screen.
class EditNote extends React.Component {

    state = {
        title: "",
        content: ""
    };

    onChangeData = (event) => {
        this.setState({[event.target.name]: event.target.value});
    };

    render() {
        return (<div>
            <input name="title" value={this.state.title} onChange={this.onChangeData} placeholder="Title"/>
            <input name="content" value={this.state.content} onChange={this.onChangeData} placeholder="Content"/>
            <h1>Data: {this.state.title} {this.state.content}</h1>
        </div>);
    }
}

export const Example = () => <EditNote/>;
