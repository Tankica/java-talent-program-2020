import React, {Component} from 'react';

// For controlled components, the idea is that you push the values from the component
// to the consumer via callback handlers. In the context of a form, this is normally
// via `onChange` which receives the `event` (and you can get the value via
// `event.target.value`) like so:
//
//     <input onChange={event => console.log(event.target.value)} />
//
// In this scenario, you also need to provide the value for the input like so:
//
//     <input value={this.state.value} />
//
// This gives you a lot more power over the input.

// Exercise:
//   Render a EditNote form with an onSubmit handler that alerts the value of both title and content
//   while saving their data in the local component state
//   The submit button needs to be disabled if there is an error.
//   Error message needs to be displayed when:
//     - The title is empty - "Title is a mandatory field"
//     - The content is empty - "Content is a mandatory field"
//     - The title contains more than 10 characters - "Title cannot contain more than 10 characters"
//   Since this is a EditNote functionality, we need to make sure to display the 'Default Title' and 'Default Content'
//   when our component is rendered.
class EditNoteForm extends Component {

    constructor(props) {
        super(props);
        this.state = {
            title: props.defaultTitle,
            content: props.defaultContent,
            disable: true,
            errors: {}
        };
    }

    componentDidMount() {
        this.checkAndDisplayErrors();
    }

    onChangeData = (event) => {
        this.setState({[event.target.name]: event.target.value}, () => this.checkAndDisplayErrors());
    };

    onSubmit = () => alert(`${this.state.title} ${this.state.content}`);

    checkAndDisplayErrors() {
        this.setState({disable: !(this.state.title.length && this.state.content.length && this.state.title.length <= 10) });

        let error =  this.state.errors;
        if (!this.state.title.length)
            error.title = "Title is a mandatory field";
        else if (this.state.title.length > 10)
            error.title = "Title cannot contain more than 10 characters";
        else
            error.title = "";

        if(!this.state.content.length)
            error.content = "Content is a mandatory field";
        else
            error.content = "";

        this.setState({errors:error});
    }

    render() {
        return <div>
            <form onSubmit={this.onSubmit}>
                <input name="title" value={this.state.title} onChange={this.onChangeData} placeholder="Title"/>
                <span style={{color: "red"}}>{this.state.errors["title"]}</span><br/>

                <input name="content" value={this.state.content} onChange={this.onChangeData} placeholder="Content"/>
                <span style={{color: "red"}}>{this.state.errors["content"]}</span><br/>

                <button disabled={this.state.disable}>Click</button>
            </form>

        </div>;
    }
}

export const Example = () => <EditNoteForm defaultTitle="Default title" defaultContent="Default Content"/>;
