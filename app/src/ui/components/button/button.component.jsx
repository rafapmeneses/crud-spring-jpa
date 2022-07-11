import "./button.style.css";

export function Button({ value, onClick, children, type, isDisabled }) {
  return (
    <button
      className="button__button-component"
      disabled={isDisabled}
      type={type}
      value={value}
      onClick={onClick}
    >
      {children}
    </button>
  );
}

Button.defaultProps = {
  disabled: false,
};