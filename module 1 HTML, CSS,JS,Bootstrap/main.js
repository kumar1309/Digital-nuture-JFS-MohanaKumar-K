// Event List
const events = [
    { id: 1, name: "Music Festival", type: "music", date: "2025-06-15", location: "Central Park", seats: 500 },
    { id: 2, name: "Art Exhibition", type: "art", date: "2025-06-20", location: "City Gallery", seats: 200 },
    { id: 3, name: "Sports Day", type: "sports", date: "2025-06-25", location: "Community Stadium", seats: 1000 },
    { id: 4, name: "Food Festival", type: "food", date: "2025-07-01", location: "Town Square", seats: 300 },
    { id: 5, name: "Charity Run", type: "charity", date: "2025-07-05", location: "River Park", seats: 50 },
    { id: 6, name: "Craft Workshop", type: "workshop", date: "2025-07-10", location: "Community Center", seats: 30 }
];

// DOM Elements
const eventTable = document.getElementById('eventTable');
const registrationForm = document.getElementById('registrationForm');
const confirmationMessage = document.getElementById('confirmationMessage');
const eventVideo = document.getElementById('eventVideo');
const savePreferencesBtn = document.getElementById('savePreferences');
const clearPreferencesBtn = document.getElementById('clearPreferences');

// Initialize page
window.addEventListener('load', () => {
    console.log('Welcome to the Community Portal');
        if (window.location.hash) {
        history.replaceState(null, '', window.location.pathname);
    }
    loadUserPreferences();
    setupImageGallery();
    setupEventHandlers();
});

// Event Handlers
function setupEventHandlers() {
    // Form submission
    registrationForm.addEventListener('submit', handleRegistration);
    
    // Video events
    eventVideo.addEventListener('canplay', () => {
        console.log('Video ready to play');
        document.getElementById('videoMessage').textContent = 'Video ready to play - Click to start!';
        document.getElementById('videoMessage').style.color = '#2ecc71';
    });
    
    eventVideo.addEventListener('play', () => {
        document.getElementById('videoMessage').textContent = 'Enjoy the event preview!';
    });
    
    eventVideo.addEventListener('pause', () => {
        document.getElementById('videoMessage').textContent = 'Video paused - Resume when ready';
    });
    
    eventVideo.addEventListener('ended', () => {
        document.getElementById('videoMessage').textContent = 'Video ended - Thanks for watching!';
    });
    
    // Window events
    window.addEventListener('beforeunload', (e) => {
        if (registrationForm.reportValidity()) {
            e.preventDefault();
            e.returnValue = 'Are you sure you want to leave? Your registration is incomplete.';
        }
    });
    
    // Preferences
    savePreferencesBtn.addEventListener('click', savePreferences);
    clearPreferencesBtn.addEventListener('click', clearPreferences);
}

// Form Handling
async function handleRegistration(e) {
    e.preventDefault();
    
    try {
        const formData = new FormData(registrationForm);
        const data = Object.fromEntries(formData.entries());
        
        // Validate form
        if (!validateForm(data)) return;
        
        // Save to localStorage
        const registrations = JSON.parse(localStorage.getItem('registrations') || '[]');
        registrations.push(data);
        localStorage.setItem('registrations', JSON.stringify(registrations));
        
        // Show confirmation
        confirmationMessage.textContent = 'Registration successful!';
        confirmationMessage.style.color = 'green';
        
        // Reset form
        registrationForm.reset();
        
        
    } catch (error) {
        console.error('Registration error:', error);
        confirmationMessage.textContent = 'Registration failed. Please try again.';
        confirmationMessage.style.color = 'red';
    }
}

function validateForm(data) {
    if (!data.name || !data.email || !data.eventDate || !data.eventType) {
        alert('Please fill in all required fields');
        return false;
    }
    return true;
}

// Event Gallery
function setupImageGallery() {
    // Get all event images
    const eventImages = document.querySelectorAll('.event-image');
    
    // Add double-click event to each image
    eventImages.forEach(img => {
        img.addEventListener('dblclick', () => {
            // Store original transform and z-index
            const originalTransform = img.style.transform;
            const originalZIndex = img.style.zIndex;
            
            // Enlarge image
            img.style.transform = 'scale(1.5)';
            img.style.zIndex = '100';
            img.style.position = 'relative';
            
            // Create overlay for enlarged image
            const overlay = document.createElement('div');
            overlay.className = 'image-overlay';
            overlay.style.position = 'fixed';
            overlay.style.top = '0';
            overlay.style.left = '0';
            overlay.style.width = '100%';
            overlay.style.height = '100%';
            overlay.style.backgroundColor = 'rgba(0,0,0,0.7)';
            overlay.style.zIndex = '99';
            document.body.appendChild(overlay);
            
            // Reset after 2 seconds
            setTimeout(() => {
                img.style.transform = originalTransform;
                img.style.zIndex = originalZIndex;
                img.style.position = '';
                document.body.removeChild(overlay);
            }, 2000);
        });
    });
}

// User Preferences
function savePreferences() {
    const selectedType = document.getElementById('eventType').value;
    if (selectedType) {
        localStorage.setItem('preferredEventType', selectedType);
        alert('Preferences saved successfully!');
    }
}

function clearPreferences() {
    localStorage.clear();
    sessionStorage.clear();
    alert('All preferences have been cleared.');
}

function loadUserPreferences() {
    const preferredType = localStorage.getItem('preferredEventType');
    if (preferredType) {
        document.getElementById('eventType').value = preferredType;
    }
}

// Geolocation
function findNearbyEvents() {
    if (!navigator.geolocation) {
        alert('Geolocation is not supported by your browser');
        return;
    }

    navigator.geolocation.getCurrentPosition(
        position => {
            const { latitude, longitude } = position.coords;
            console.log(`Coordinates: ${latitude}, ${longitude}`);
            // Here you would typically make an API call to find nearby events
            alert('Your location has been found!');
        },
        error => {
            switch(error.code) {
                case error.PERMISSION_DENIED:
                    alert("User denied the request for Geolocation.");
                    break;
                case error.POSITION_UNAVAILABLE:
                    alert("Location information is unavailable.");
                    break;
                case error.TIMEOUT:
                    alert("The request to get user location timed out.");
                    break;
                case error.UNKNOWN_ERROR:
                    alert("An unknown error occurred.");
                    break;
            }
        },
        { 
            enableHighAccuracy: true,
            timeout: 5000,
            maximumAge: 0 
        }
    );
}

// Debugging
console.log('Event List:', events);
console.log('Available features:', {
    geolocation: !!navigator.geolocation,
    localStorage: typeof localStorage !== 'undefined',
    sessionStorage: typeof sessionStorage !== 'undefined'
});

window.addEventListener('beforeunload', function () {
    window.scrollTo(0, 0);
});
window.addEventListener('load', function () {
    window.scrollTo(0, 0);
});
