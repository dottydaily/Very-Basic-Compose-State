# Session Outline : Very Basic Compose State

- How Compose render UI? (Composition vs Initial compositon vs Recomposition)
  - Answer : Compose uses Composable function to determine how to render the UI.
    - When Compose executes Composable function to render the UI. It's called "Composition"
    - When Compose executes Composable function in the first time. It's called "Initial Composition"
    - When Compose try to re-executes Composable function to render UI changes is called "Recomposition"
    - [https://developer.android.com/jetpack/compose/lifecycle](https://developer.android.com/jetpack/compose/lifecycle)
- What is the "State" in Jetpack Compose?
  - State is value that Compose use to do the "Recomposition" (It also uses in the initial composition as well)
- How to write a State? (See FirstExample.kt)
  - Show example of the Composable function which isn't using State.
  - Try using State without remember.

## Q&A "Does Recomposition happen?" (Answer : Yes)

- Introduce "remember" function.
  - Remember function is an API that can be used in Composable function to store an object in memory during Composition.
- A little detail on remember
  - How it contain state from recomposition
    - It will store an state object in the initial composition. and return the stored value on the next recomposition phase.
  - What happen to the state in remember if the owner (composable function) has exited the composition?
    - The stored object will be gone with the owner composition function which is exited the composition.
  - What happen to the state in remember if the app make a configuration changes?
    - The stored object will be gone. Please use rememberSavable

## Q&A Is State in Compose always a mutable value? (Answer : No)

## Stateful vs Stateless

- What is Stateful / Stateless (Stateful is Composable function that own state, Stateless is the opposite of Stateful)
  - Which one is better?
    - It depend on the situation. But Stateless is the preferred way to do more than Stateful since it can be reusable in many case.
  - How to convert Stateful to Stateless?
    - Move any state in the Composable function to the closest owner who called this Composalbe function
  - Explain what is this approach call?
    - State hoisting. Unidirection Flow (State goes down, Event goes up)
  - State should be hoist to at least the lowest parent of all composable that read the state.
  - State should be hoist to at least the highest level it may be changed state.

## Example

- Card view
- Car animation. (Sneak peak of how to do an Animation in Compose)
- Extra : State hosting in ViewModel